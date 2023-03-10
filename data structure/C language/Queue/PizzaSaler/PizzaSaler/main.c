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
		initOven(ovenp, id);//scanf�� ������ �о �޾Ƶ��̴� �κ�
	};
	printf("\n\n  ====== �޴��� ======\n");
	for (int i = 0; i < numOvens; i++) {
		printMenu(&ovenList[i]);//�װ� ��½����ִ� �κ�
	}
}
void initOven(Oven* p, int d) {//
	scanf("%s %d", p->pizza_name, &p->takeminute);
	p->pizza_number = d;
	p->finish = 0;
	init_queue(&p->logQ);
}////

void printMenu(Oven* p) {
	printf("[%d] %s  (�丮�ð� %d ��)\n", p->pizza_number, p->pizza_name, p->takeminute);
}/////



void runOrders() {
	int id;
	init_queue(&orderQ);
	Order* orderp = NULL;
	Oven* ovenp = NULL;
	while (1) {
		scanf_s("%d", &id);
		if (id == 0) break;
		orderp = &orderList[numOrders++];//�ֹ��� ��� �޴� �κ�
		read_order(orderp, id);//�ֹ� �޴� �κ�
		ovenp = findOven(orderp->ovennum);//�ֹ� ���� ���ڿ� ���� ���� ã��
		//�ֹ��� �־���ϴ��� Oven�� �ּҸ� ã�� �Լ�(��ȣ�� �б� ������)
		add_order(ovenp, orderp);//enqueue�� �߻��Ѵ�.
	};
	for (int i = 0; i < numOrders; i++) {
		ovenp = findOven(orderList[i].ovennum);
		cook(ovenp);//queue�� �ִ� �͵��� �丮�϶�� ��Ŵ
		//�丮�� ������ �׷� dequeue�ؼ� log queue��
			//enqueue�ϸ� �ȴ�.
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
	printf("���� �� �丮 ����:\n");
	for (int i = 0; i < numOvens; i++) {
		Oven* ovenp = &ovenList[i];
		printLog(ovenp);//log�� �ִ� ������ ���ʷ� ���
	}
}

void printLog(Oven* p) {
	/*[1] paparoni(�丮�ð� 3��)
		(2) paparoni  6��--  6��--  9��*/
	printMenu(p);
	while (!is_empty(&p->logQ)) {
		element k = dequeue(&p->logQ);
		printf("(%d) %s %d��-- %d��-- %d��\n",
			k->id, p->pizza_name, k->orderTime, k->startTime, k->outTime);
	}
}


Oven* findOven(int pnum) {
	for (int i = 0; i < numOvens; i++)
		if (ovenList[i].pizza_number == pnum)
			return &ovenList[i];
	return NULL;
}