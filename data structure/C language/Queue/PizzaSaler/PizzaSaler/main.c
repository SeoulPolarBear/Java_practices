#include "pizza.h"

void main() {
	readMenus();
	runOrders();
	printLogs();
}
void readMenus() {

	int id;
	Oven* ovenp = NULL;
	while (1) {
		scanf_s("%d", &id);
		if (id == 0) break;
		ovenp = &ovenList[numOvens++];
		initOven(ovenp, id);//scanf로 오븐을 읽어서 받아들이는 부분
	};
	printf("\n\n  ====== 메뉴판 ======\n");
	for (int i = 0; i < numOvens; i++) {
		printMenu(&ovenList[i]);//그걸 출력시켜주는 부분
	}
}
void initOven(Oven* p, int d) {//
	scanf("%s %d", p->pizza_name, &p->takeminute);
	p->pizza_number = d;
	p->finish = 0;
	init_queue(&p->logQ);
}////

void printMenu(Oven* p) {
	printf("[%d] %s  (요리시간 %d 분)\n", p->pizza_number, p->pizza_name, p->takeminute);
}/////



void runOrders() {
	int id;
	init_queue(&orderQ);
	Order* orderp = NULL;
	Oven* ovenp = NULL;
	while (1) {
		scanf_s("%d", &id);
		if (id == 0) break;
		orderp = &orderList[numOrders++];//주문을 계속 받는 부분
		read_order(orderp, id);//주문 받는 부분
		ovenp = findOven(orderp->ovennum);//주문 받은 피자와 같은 오븐 찾기
		//주문을 넣어야하는지 Oven의 주소를 찾는 함수(번호로 읽기 때문에)
		add_order(ovenp, orderp);//enqueue가 발생한다.
	};
	for (int i = 0; i < numOrders; i++) {
		ovenp = findOven(orderList[i].ovennum);
		cook(ovenp);//queue에 있는 것들을 요리하라고 시킴
		//요리가 끝나면 그럼 dequeue해서 log queue에
			//enqueue하면 된다.
	}
}
void add_order(Oven* p, Order* o) {
	if (p->finish < o->orderTime)
		o->startTime = o->orderTime;
	else
		o->startTime = p->finish;

	enqueue(&orderQ, o);
	//void enqueue(QueueType * q, element item);


}

void read_order(Order* p, int d) {
	scanf_s("%d %d", &p->orderTime, &p->ovennum);
	p->id = d;
}

void cook(Oven* p) {
	element o = dequeue(&orderQ);
	p->finish = o->startTime + p->takeminute;
	o->outTime = p->finish;
	enqueue(&p->logQ, o);
}

void printLogs() {
	printf("오븐 별 요리 내역:\n");
	for (int i = 0; i < numOvens; i++) {
		Oven* ovenp = &ovenList[i];
		printLog(ovenp);//log에 있는 내용을 차례로 사용
	}
}

void printLog(Oven* p) {
	/*[1] paparoni(요리시간 3분)
		(2) paparoni  6분--  6분--  9분*/
	printMenu(p);
	while (!is_empty(&p->logQ)) {
		element k = dequeue(&p->logQ);
		printf("(%d) %s %d분-- %d분-- %d분\n",
			k->id, p->pizza_name, k->orderTime, k->startTime, k->outTime);
	}
}


Oven* findOven(int pnum) {
	for (int i = 0; i < numOvens; i++)
		if (ovenList[i].pizza_number == pnum)
			return &ovenList[i];
	return NULL;
}