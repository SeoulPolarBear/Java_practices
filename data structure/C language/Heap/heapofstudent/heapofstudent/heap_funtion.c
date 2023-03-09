#include "heap.h"
#include <stdio.h>
#include <stdlib.h>
#include<string.h>

void insert_max_heap(HeapType* h, element item) {
	int i;
	i = ++(h->heap_size);
	
while ((i != 1) && (item->avg > h->heap[i / 2]->avg)) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;
}

element delete_max_heap(HeapType* h) {
	int parent, child;
	element item, temp;

	item = h->heap[1];
	//배열 맨끝 값을 대입후 size를 줄여서 삭제됨을 표현
	temp = h->heap[(h->heap_size)--];
	parent = 1;
	child = 2;
	while (child <= h->heap_size) {
		//왼쪽 자식이 오른쪽 자식 보다 작을 떄
		if ((child < h->heap_size) &&
			(h->heap[child]->avg) < h->heap[child + 1]->avg)
			child++;
		if (temp->avg >= h->heap[child]->avg) break;
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}

void init(HeapType* h) {
	h->heap_size = 0;
}
HeapType* create() {
	return (HeapType*)malloc(sizeof(HeapType));
}

void heap_sort(element a[], int n) {
	int i;
	HeapType* h;

	h = create();
	init(h);
	for (i = 0; i < n; i++) {
		insert_max_heap(h, a[i]);
	}
	for (i = (n - 1); i >= 0; i--) {
		a[i] = delete_max_heap(h);
	}
	free(h);
}

element read_student() {
	student_t* student =(student_t*)malloc(sizeof(student_t));
	char s[10];
	int k, n, m;
	scanf("%s %d %d %d", s, &k, &n, &m);
	for(int i = 0; i<strlen(s); i++)
	student->name[i] = s[i];
	student->score[0] = k;
	student->score[1] = n;
	student->score[2] = m;
	
	student->avg = (student->score[0] + student->score[1] + student->score[2]) / 3;
	return student;
	
}
void print_student(element std) {
	printf("	%s	%d	%d	%d	( %lf)\n", std->name, std->score[0], std->score[1], std->score[2], std->avg);
}