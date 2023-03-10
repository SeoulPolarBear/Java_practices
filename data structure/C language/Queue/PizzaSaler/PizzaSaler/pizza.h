#pragma once
#include <stdio.h>
#include <stdlib.h>
// ===== ����ť �ڵ� ���� ======
#define MAX_QUEUE_SIZE 20
#define PIZZA_NAME 20
//struct Oven;
typedef struct {
	int id;
	int startTime, outTime;
	int orderTime;
	int ovennum;
} Order;

typedef Order* element;
typedef struct { // ť Ÿ��
	element  data[MAX_QUEUE_SIZE];
	int  front, rear;
} QueueType;

typedef struct {
	int pizza_number;//�̰� id �̴�.(1,2,3,4)
	char pizza_name[PIZZA_NAME];
	int takeminute;
	int finish;
	QueueType logQ;
} Oven;

Oven ovenList[10];
Order orderList[100];
QueueType orderQ;
int numOvens;
int numOrders;
void readMenus();
void runOrders();
void printLogs();
void initOven(Oven* p, int d);
void printMenu(Oven* p);
void add_order(Oven* p, Order* o);
void read_order(Order* p, int d);
Oven* findOven(int pnum);
void cook(Oven* p);
void printLog(Oven* p);

// ���� �Լ�
void error(char* message);

// ���� ���� ���� �Լ�
void init_queue(QueueType* q);

// ���� ���� ���� �Լ�
int is_empty(QueueType* q);

// ��ȭ ���� ���� �Լ�
int is_full(QueueType* q);

// ����ť ��� �Լ�
/*void print_queue2(QueueType* q);
void print_queue(QueueType* q, int b_enq, int e);*/

// ���� �Լ�
void enqueue(QueueType* q, element item);

// ���� �Լ�
element dequeue(QueueType* q);

// ���� �Լ�
element peek(QueueType* q);

