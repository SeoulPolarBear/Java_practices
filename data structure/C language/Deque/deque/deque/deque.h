#pragma once
#pragma once
#include <stdio.h>
#include <stdlib.h>

#define ADD_F 1//앞으로 넣기
#define ADD_R 2//뒤로 넣기
#define REMOVE_F 3//앞으로빼기
#define REMOVE_R 4//뒤로 빼기

#define MAX_QUEUE_SIZE 8
typedef int element;
typedef struct { // 큐 타입
	element  data[MAX_QUEUE_SIZE];
	int  front, rear;
} DequeType;
void error(const char* message);
void init_deque(DequeType* q);
int is_empty(DequeType* q);
int is_full(DequeType* q);
void print_queue(DequeType* q, int command, element e);
void add_front(DequeType* q, element item);
void add_rear(DequeType* q, element item);
element delete_front(DequeType* q);//앞에꺼 제거
element delete_rear(DequeType* q);//뒤에꺼 제거
element get_front(DequeType* q);// 앞에꺼 보기
element get_rear(DequeType* q);//뒤어꺼 보기