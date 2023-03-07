#include<stdio.h>
#include<stdlib.h>
#include<string.h>


/*typedef int element;*/

typedef struct {
	int x;
	int y;
}element;
 
typedef struct {
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
