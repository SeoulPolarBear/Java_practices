#pragma once
#include <stdio.h>
#include <stdlib.h>

// ===== 원형큐 코드 시작 ======
#define MAX_QUEUE_SIZE 5
typedef int element;
typedef struct { // 큐 타입
	element  data[MAX_QUEUE_SIZE];
	int  front, rear;
} QueueType;

void error(char* message);
void init_queue(QueueType* q);
int is_empty(QueueType* q);//true or false
int is_full(QueueType* q);//true or false
void print_queue(QueueType* q, int b_enq, element e);
void enqueue(QueueType* q, element item);
element dequeue(QueueType* q);
element peek(QueueType* q);