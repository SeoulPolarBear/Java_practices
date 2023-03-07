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
	if (x >= maze_size || y >= maze_size) return;// ���� �Ѿ��� ��
	if (maze[x][y] != WALL && maze[x][y] != VISITED && maze[x][y] != PATH) {
		element tmp;
		tmp.x = x;
		tmp.y = y;
		push(tovisit, tmp);
	}
}

void print_stack(StackType* stack, const char* token) {// �׳� stack ���
	printf("%-12s [stack] ", token);
	for (int i = 0; i <= stack->top; i++) {
		printf("(%d,%d) ", stack->data[i].x, stack->data[i].y); // element Ÿ�Կ� ���� ���������� ���� �ʿ� 
	}
	printf("\n");
}

// �̷θ� ȭ�鿡 ����Ѵ�. 
void maze_print()
{
	printf("\n");
	for (int x = 0; x < maze_size; x++) {
		printf("%s\n", maze[x]);  // ���྿ ���ڿ�ó�� ���
	}
	print_stack(&tovisit, "unvisited");//�� stack�� �߷��ϰ�
	print_stack(&path, "path");//���� ������ ��θ� ��Ÿ���ش�
}
void init_maze(element* entry)
{
	printf("maze size = ");
	scanf_s("%d", &maze_size);
	for (int x = 0; x < maze_size; x++) {
		printf("%d��: ", x);  // �� �྿ ���ڿ�ó�� �Է�
		scanf_s("%s", maze[x], MAZE_SIZE);//���ڿ�ó�� maze�� �޴´�.
	}
	printf("������ġ:");
	scanf_s("%d %d", &entry->x, &entry->y);//maze ������ ó�� ���ۺκ��� �޴´�
}
int neighbor(element here, element next)
{
	return (abs(here.x - next.x) + abs(here.y - next.y) == 1);// ���� �¿� �� �� �ִ� ĭ�ΰ��� ���� �Լ�
}

int main(void)
{
	init_stack(&tovisit);
	init_stack(&path);
	init_maze(&entry);
	if (maze[entry.x][entry.y] == GOAL) {
		printf("������� �������� �����ϴ�.\n");
		return 0;
	}
	findPath(entry);
	return 0;
	
}
// here�� PATH�� �ȴ�.
// here �ڸ��� �̵��ϰ� �ű⼭ �»������ push_loc�� �Ѵ�
void move(element here) {//�����¿�
	push_loc(&tovisit, here.x - 1, here.y);
	push_loc(&tovisit, here.x + 1, here.y);
	push_loc(&tovisit, here.x, here.y - 1);
	push_loc(&tovisit, here.x, here.y + 1);
	maze[here.x][here.y] = PATH;
}
// ���� ��ġ here���� ������ tovisit�� push�ص� ���� ���� next���� ���Ѵ�
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
		if (maze[here.x][here.y] == GOAL) {// ��� �̵��� here�� GOAL�� ������ ��θ� ã�� ���̰�
			push(&path, here);
			maze[here.x][here.y] = PATH;//������ ��θ� #���� ǥ��
			maze_print();
			printf("��� �߰�!!!!\n");
			break;
		}
		move(here);//�������� �̵��� �� ����ϴ� �Լ�
		if (is_empty(&tovisit)) {  // ���̻� ������ ������ ���� ���ٴ� ��
			maze[here.x][here.y] = VISITED;//������ ��θ� .���� ǥ��
			printf("����\n");//�ᱹ ������ ��� ���ж�� ��
			break;
		}
		next = pop(&tovisit);  // ������ �� ���� ���� (�� �� �� �� ������ �湮)
		here = go_back_to(here, next);//here���� next���� �� �� �ִ� here���� �����ϴ� �Լ� 
		element p = peek(&path);// �̺κ��� next���ܰ� ���� pop ��츦 ����ؼ� ����� ���� �Լ��̴�.
		if (p.x != here.x || p.y != here.y)
			push(&path, here);// push_loc(&s, here);  X
		here = next;
	}
	return 1;
}


