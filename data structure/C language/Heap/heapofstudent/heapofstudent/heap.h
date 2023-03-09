#pragma once
#define Max_ELEMENT 20

typedef struct {
	char name[10];
	int score[3];
	double avg;
}student_t;

typedef student_t* element;

typedef struct {
	element heap[Max_ELEMENT];
	int heap_size;
}HeapType;



void init(HeapType* h);
HeapType* create();
void insert_max_heap(HeapType* h, element item);
element delete_max_heap(HeapType* h);
void heap_sort(element a[], int n);
element read_student();
void print_student(element std);