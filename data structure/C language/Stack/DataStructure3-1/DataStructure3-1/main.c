#include "stack.h"
#include "stack.c"
#define MAZE_SIZE 20
#define WALL '1'
#define ROAD '0'
#define GOAL 'x'
#define VISITED '.'
#define PATH '#'
int maze_size = 0;
element entry = { 0,0 };
char maze[MAZE_SIZE][MAZE_SIZE];
StackType tovisit, path;

void push_loc(StackType* tovisit, int r, int c);
void print_stack(StackType* stack, const char* token);
void maze_print();
void init_maze(element* entry);
int neighbor(element here, element next);
void move(element here);
element go_back_to(element here, element next);
int findPath(element here);


void push_loc(StackType* tovisit, int x, int y)
{
	if (x < 0 || y < 0) return;
	if (x >= maze_size || y >= maze_size) return;// 벽을 넘었을 때
	if (maze[x][y] != WALL && maze[x][y] != VISITED && maze[x][y] != PATH) {
		element tmp;
		tmp.x = x;
		tmp.y = y;
		push(tovisit, tmp);
	}
}

void print_stack(StackType* stack, const char* token) {// 그냥 stack 출력
	printf("%-12s [stack] ", token);
	for (int i = 0; i <= stack->top; i++) {
		printf("(%d,%d) ", stack->data[i].x, stack->data[i].y); // element 타입에 따라 형식지정자 수정 필요 
	}
	printf("\n");
}

// 미로를 화면에 출력한다. 
void maze_print()
{
	printf("\n");
	for (int x = 0; x < maze_size; x++) {
		printf("%s\n", maze[x]);  // 한행씩 문자열처럼 출력
	}
	print_stack(&tovisit, "unvisited");//갈 stack을 추력하고
	print_stack(&path, "path");//내가 지나온 경로를 나타내준다
}
void init_maze(element* entry)
{
	printf("maze size = ");
	scanf_s("%d", &maze_size);
	for (int x = 0; x < maze_size; x++) {
		printf("%d행: ", x);  // 한 행씩 문자열처럼 입력
		scanf_s("%s", maze[x], MAZE_SIZE);//문자열처럼 maze를 받는다.
	}
	printf("시작위치:");
	scanf_s("%d %d", &entry->x, &entry->y);//maze 생성후 처음 시작부분을 받는다
}
int neighbor(element here, element next)
{
	return (abs(here.x - next.x) + abs(here.y - next.y) == 1);// 상하 좌우 갈 수 있는 칸인가를 묻는 함수
}

int main(void)
{
	init_stack(&tovisit);
	init_stack(&path);
	init_maze(&entry);
	if (maze[entry.x][entry.y] == GOAL) {
		printf("출발점이 목적지와 같습니다.\n");
		return 0;
	}
	findPath(entry);
	return 0;
	
}
// here는 PATH가 된다.
// here 자리로 이동하고 거기서 좌상우하의 push_loc을 한다
void move(element here) {//상하좌우
	push_loc(&tovisit, here.x - 1, here.y);
	push_loc(&tovisit, here.x + 1, here.y);
	push_loc(&tovisit, here.x, here.y - 1);
	push_loc(&tovisit, here.x, here.y + 1);
	maze[here.x][here.y] = PATH;
}
// 현재 위치 here에서 이전에 tovisit에 push해둔 다음 갈길 next까지 백한다
element go_back_to(element here, element next) {
	while(!neighbor(here, next)) {
		maze[here.x][here.y] = VISITED;
		here = pop(&path);
	}
	return here;
}


int findPath(element here) {
	element next;
	push(&path, here);
	while (1) {
		if (maze[here.x][here.y] == GOAL) {// 골과 이동한 here와 GOAL이 같으면 경로를 찾은 것이고
			push(&path, here);
			maze[here.x][here.y] = PATH;//지나간 경로를 #으로 표시
			maze_print();
			printf("경로 발견!!!!\n");
			break;
		}
		move(here);//다음으로 이동할 때 사용하는 함수
		if (is_empty(&tovisit)) {  // 더이상 갈곳이 없으면 길이 없다는 뜻
			maze[here.x][here.y] = VISITED;//지나간 경로를 .으로 표시
			printf("실패\n");//결국 갈길이 없어서 실패라고 뜸
			break;
		}
		next = pop(&tovisit);  // 다음에 갈 곳을 꺼냄 (우 좌 하 상 순서로 방문)
		here = go_back_to(here, next);//here에서 next까지 갈 수 있는 here까지 가야하는 함수 
		element p = peek(&path);// 이부분은 next전단계 까지 pop 경우를 대비해서 만들어 놓은 함수이다.
		if (p.x != here.x || p.y != here.y)
			push(&path, here);// push_loc(&s, here);  X
		here = next;
	}
	return 1;
}


