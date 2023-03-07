#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAZE_SIZE 6

/*typedef int element;*/

typedef struct {
	short r;
	short c;
}element;

typedef struct {
	element *data;
	int capacity;
	int top;
}StackType;



void init_stack(StackType *s);
int is_empty(StackType *s);
int is_full(StackType *s);
void push(StackType *s, element item);
element pop(StackType *s);



void maze_print(char maze[MAZE_SIZE][MAZE_SIZE]);


