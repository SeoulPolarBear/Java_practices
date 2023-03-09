#include "heap.h"
#include<stdio.h>
#include<stdlib.h>
#define SIZE 200

int main(void)
{
	element ptr_list[SIZE];
	int n;
	scanf_s("%d", &n);
	
	for (int i = 0; i < n; i++)
		ptr_list[i] = read_student();
	
	heap_sort(ptr_list, n);
	printf("\n=======평균 순서로 출력=======\n");
	for (int j = 0; j < n; j++) {
		print_student(ptr_list[j]);
	}
}