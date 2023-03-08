#pragma once
#pragma once
#include <stdio.h>
#include <stdlib.h>

#define ADD_F 1//������ �ֱ�
#define ADD_R 2//�ڷ� �ֱ�
#define REMOVE_F 3//�����λ���
#define REMOVE_R 4//�ڷ� ����

#define MAX_QUEUE_SIZE 8
typedef int element;
typedef struct { // ť Ÿ��
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
element delete_front(DequeType* q);//�տ��� ����
element delete_rear(DequeType* q);//�ڿ��� ����
element get_front(DequeType* q);// �տ��� ����
element get_rear(DequeType* q);//�ھ ����