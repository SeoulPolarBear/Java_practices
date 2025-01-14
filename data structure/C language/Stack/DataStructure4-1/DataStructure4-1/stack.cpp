#include "stack.h"

void init_stack(StackType* s)
{
	s->capacity = 8;
	s->data = (element*)malloc(s->capacity * sizeof(element));
	s->top = -1;
}

int is_empty(StackType* s)
{
	return (s->top == -1);
}

int is_full(StackType* s) {
	return (s->top == (s->capacity - 1));
}

void push(StackType* s, element item)
{
	if (is_full(s)) {
		s->capacity*= 2;
		s->data = (element*)realloc(s->data, s->capacity * sizeof(element));
	}
	else s->data[++(s->top)] = item;
}

element pop(StackType* s) {
	if (is_empty(s)) {
		fprintf(stderr, "스택 공백 에러\n");
		exit(1);
	}
	else return s->data[(s->top)--];
}

element peek(StackType* s) {
	if (is_empty(s)) {
		fprintf(stderr, "스택 공백\n");
		exit(1);
	}
	else return s->data[s->top];

}