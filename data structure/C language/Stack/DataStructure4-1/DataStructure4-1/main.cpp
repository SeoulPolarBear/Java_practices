#include "stack.h"
#define MAZE_SIZE 20
#define WALL '1'
#define ROAD '0'
#define GOAL 'x'
#define VISITED '.'
#define PATH '#'
int maze_size = 0;
element entry = { 0, 0 };
char maze[MAZE_SIZE][MAZE_SIZE];
StackType tovisit, path;  // 갈림길스택, 방문한경로스택

// 위치를 스택에 삽입
// 미로 내의 좌표이고 벽이나 이미 방문한 경로가 아니면
// 그것을 element를 만들어서 push
void push_loc(StackType* tovisit, int x, int y)
{
	if (x < 0 || y < 0) return;
	if (x >= maze_size || y >= maze_size) return;
	if (maze[x][y] != WALL && maze[x][y] != VISITED && maze[x][y] != PATH) {
		element tmp;
		tmp.x = x;
		tmp.y = y;
		push(tovisit, tmp);
	}
}
void print_stack(StackType* stack, const char* token) {
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
	print_stack(&tovisit, "unvisited");
	print_stack(&path, "path");
}
void init_maze(element* entry)
{
	printf("maze size = ");
	scanf_s("%d", &maze_size);
	for (int x = 0; x < maze_size; x++) {
		printf("%d행: ", x);  // 한 행씩 문자열처럼 입력
		scanf_s("%s", maze[x], MAZE_SIZE);
	}
	printf("시작위치:");
	scanf_s("%d %d", &entry->x, &entry->y);
}
int neighbor(element here, element next)
{
	return (abs(here.x - next.x) + abs(here.y - next.y) == 1);
}
// here 자리로 이동하고 거기서 좌상우하의 push_loc을 한다
// here는 PATH가 된다.
void move(element here) {
	push_loc(&tovisit, here.x - 1, here.y);
	push_loc(&tovisit, here.x + 1, here.y);
	push_loc(&tovisit, here.x, here.y - 1);
	push_loc(&tovisit, here.x, here.y + 1);
	maze[here.x][here.y] = PATH;


}
// 현재 위치 here에서 이전에 tovisit에 push해둔 다음 갈길 next까지 백한다
element go_back_to(element here, element next) {
	while (!neighbor(here, next)) {
		maze[here.x][here.y] = VISITED;
		here = pop(&path);
	}
	return here;
}
int findPath(element here);
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

int findPath(element here) {
	element next;
	push(&path, here);
	while (1) {
		if (maze[here.x][here.y] == GOAL) {
			push(&path, here);
			maze[here.x][here.y] = PATH;
			maze_print();
			printf("경로 발견!!!!\n");
			break;
		}
		move(here);
		if (is_empty(&tovisit)) {  // 더이상 갈곳이 없으면 길이 없다는 뜻
			maze[here.x][here.y] = VISITED;
			printf("실패\n");
			break;
		}
		next = pop(&tovisit);  // 다음에 갈 곳을 꺼냄 (우좌하상 순서로 방문)
		here = go_back_to(here, next);
		element p = peek(&path);
		if (p.x != here.x || p.y != here.y)
			push(&path, here);   // push_loc(&s, here);  X
		here = next;
	}
	return 1;
}
