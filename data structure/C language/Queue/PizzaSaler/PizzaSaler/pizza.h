#pragma once
#include <stdio.h>
#include <stdlib.h>
// ===== 원형큐 코드 시작 ======
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
typedef struct { // 큐 타입
	element  data[MAX_QUEUE_SIZE];
	int  front, rear;
} QueueType;

typedef struct {
	int pizza_number;//이게 id 이다.(1,2,3,4)
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

// 오류 함수
void error(char* message);

// 공백 상태 검출 함수
void init_queue(QueueType* q);

// 공백 상태 검출 함수
int is_empty(QueueType* q);

// 포화 상태 검출 함수
int is_full(QueueType* q);

// 원형큐 출력 함수
/*void print_queue2(QueueType* q);
void print_queue(QueueType* q, int b_enq, int e);*/

// 삽입 함수
void enqueue(QueueType* q, element item);

// 삭제 함수
element dequeue(QueueType* q);

// 삭제 함수
element peek(QueueType* q);

