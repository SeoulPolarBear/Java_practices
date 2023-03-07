#pragma once
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


/*typedef int element;*/

typedef struct {
	int x;
	int y;
}element;

typedef struct tag {
	element* data;
	int capacity;
	int top;
}StackType;

void init_stack(StackType* s);
int is_empty(StackType* s);
int is_full(StackType* s);
void push(StackType* s, element item);
element pop(StackType* s);
element peek(StackType* s);
void push_loc(StackType* tovisit, int x, int y);
void print_stack(StackType* stack, const char* token);
void maze_print();
void init_maze(element* entry);
int neighbor(element here, element next);
void move(element here);
element go_back_to(element here, element next);

