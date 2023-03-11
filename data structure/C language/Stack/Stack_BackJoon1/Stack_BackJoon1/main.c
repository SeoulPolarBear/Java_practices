#include<stdio.h>
#include<stdlib.h>
#define SIZE1 10
#define SIZE2 2
#define SIZE3 30

int* init_stack() {
	int* head = (int*)malloc(SIZE1*sizeof(int));
	return head;
}

//void extend_stack(int* stack) {
//	stack = (int*)realloc(stack, SIZE2 * sizeof(int));
//}
//
//void full(int* stack) {
//
//}

void PUSH(int* head, int X, int* top) {
	*(top)++;
	head[*(top)] = X;
}

int EMPTY(int* top) {
	if (*(top) == -1) return 1;
	else return 0;
}

int POP(int* head, int* top) {
	if (EMPTY) return -1;
	else {
		int	p = head[*(top)];
		*(top)--;
		head[*(top)] = NULL;
		return p;
	}
}

int Size(int* top) {
	return *(top)+1;
}

int TOP(int* head, int* top) {
	if (EMPTY) return -1;
	else return head[*(top)];
}
void INSERT(char insert) {
	
}

int main(){
	int* head = init_stack();//처음 스택 생성
	int* t = (int*)malloc(sizeof(int));
	typedef struct insert {
		char ins[SIZE1];
	}insert;
	insert* Insert = (insert*)malloc(sizeof(insert) * SIZE3);
	//if(insert)
	int stack_row;
	scanf("%d", &stack_row);
	*(t) = -1;
	for (int i=0; i < stack_row; i++) {
		scanf("%s", Insert[i].ins);
	}


	for (int i = 0; i < stack_row; i++) {
		if (strcmp(Insert[i].ins, "push") == 0) {
			int num;
			scanf("%d\n", &num);
			PUSH(head, num, t);
		}
		else if (strcmp(Insert[i].ins, "pop") == 0) {
			printf("%d\n", POP(head, t));
		}
		else if (strcmp(Insert[i].ins, "size") == 0) {
			printf("%d\n", Size(t));
		}
		else if (strcmp(Insert[i].ins, "empty") == 0) {
			printf("%d\n", EMPTY(head, t));
		}
		else if (strcmp(Insert[i].ins, "top") == 0) {
			printf("%d\n", TOP(head, t));
		}
		else printf("다시 입력해 주세요.");
	}
	//printf("%d\n", POP(head, t));
	//printf("%d\n", head[0]);
	return 0;
}






//typedef struct Stack {
//	int x;//스택의 정수 값
//	int top;//스택의 위치
//}Stack;
//
//Stack* init_stack() {
//	Stack* head = (Stack*)malloc(SIZE1 * sizeof(Stack));
//	head->x = NULL;
//	head->top = -1;
//	return head;
//}
//
//void extend_stack(Stack* stack) {
//	stack = (Stack*)realloc(stack, SIZE2 * sizeof(Stack));
//}
//
//void push(Stack* head, int X) {
//	head->top = +1;
//	head[head->top].x = X;
//
//}
//
//int main() {
//	Stack* head = init_stack();//처음 스택 생성
//
//	push(&head, 10);
//	printf("%d", head->x);
//}
