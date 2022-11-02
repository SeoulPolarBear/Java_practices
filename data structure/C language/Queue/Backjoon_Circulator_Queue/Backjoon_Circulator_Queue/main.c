#include<stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct Node {
	element data;
	struct Node* right;
	struct Node* left;
	int position;
}Node;

typedef struct Queue {
	Node* front;
	Node* rear;
	int size;//��������
}Queue;

void init(Queue* Q, int SIZE) {
	Q->front = NULL;
	Q->rear = NULL;
	Q->size = SIZE;
	int POSITION = 1;//�����ϱ� ���ؼ�
	if (Q->front == NULL && Q->rear == NULL) {
		Node* new_node = (Node*)malloc(sizeof(Node));
		Q->front = new_node;
		Q->rear = new_node;
		new_node->left = new_node;
		new_node->right = new_node;
		new_node->position = POSITION;
		POSITION++;
	}
	else {
	while (Q->rear->position != (Q->size + 1) % SIZE){
		Node* new_node = (Node*)malloc(sizeof(Node));
		//new_node->data = Data;
			new_node->left = Q->rear;
			new_node->right = Q->front;
			Q->rear->right = new_node;
			Q->front->left = new_node;
			Q->rear = new_node;
			Q->rear->position = POSITION;
			POSITION++;
		}
	}
}
int empty(Queue* Q) {
	if (Q->front == NULL && Q->rear == NULL) {
		return 1;
	}
	else return 0;
}
/*int full_Queue(Queue* Q) {
	while
	else return 0;
}*/

void Cir_Enqueue(Queue* Q, element Data, int Pos) {
	Node* temp = (Node*)malloc(sizeof(Node));
	temp = Q->front;
	while (temp->position != Pos) {
		temp = temp->right;
		if (temp->position == Q->front->position + Q->size) {
			printf("ã���ô� ��ġ�� �������� �ʽ��ϴ�.");
		}
	}
	temp->data = Data;
	temp = NULL;
	free(temp);
}

element Cir_Dequeue(Queue* Q) {
	Node* temp = (Node*)malloc(sizeof(Node));
	element pop = 0;
	if (empty(Q)) {
		printf("ť�� �������� �ʽ��ϴ�.");
	}
	else {
		pop = Q->front->data;
		temp = Q->front->right;
		free(Q->front);
		if (empty(Q)) {
			printf("ť�� �� ���� �Ͽ����ϴ�.");
		}
		else {
			Q->front = Q->front->right;
			Q->front->left = Q->rear;
			Q->rear->right = Q->front;
		}
	}
	return pop;
}//1�� ������ �������.

void Shift_left(Queue* Q) {
	Q->front = Q->front->right;
	Q->rear = Q->rear->right;
}

void Shift_right(Queue* Q) {
	Q->front = Q->front->left;
	Q->rear = Q->rear->left;
}

void Solution(Queue* Q, int num, int NUM) {
	int count = 0;//�� �� �����̴� �� üũ
	element pop;
	int* DEQ = (int*)malloc(num * sizeof(int));
	for (int j = 0; j < num; j++) {
		scanf("%d ", &DEQ[j]);
		printf("111111");
	}
	for (int i = 0; i < num; i++) {
		if (DEQ[i]+1 < DEQ[i + 1] || DEQ[i + 1] <= (DEQ[i] + NUM / 2) % NUM) {
			while(Q->front->position != DEQ[i + 1]) {
				Shift_left(Q);
				count++;
			}
			pop = Cir_Dequeue(Q);
		}
		else if ((DEQ[i] + 1) == DEQ[i + 1]) {
			pop = Cir_Dequeue(Q);
		}
		else {
			while(Q->front->position != DEQ[i + 1]) {
				Shift_right(Q);
				count++;
			}
			pop = Cir_Dequeue(Q);
		}
		NUM--;
	}
	printf("%d", count);
}

int main() {
	int NUM;//ť�� SIZE
	int num;// �̾Ƴ����� ���� ����
	Queue q;
	scanf("%d", &NUM);
	scanf("%d\n", &num);
	init(&q, NUM);
	for (int i = 1; i <= NUM; i++) {
		Cir_Enqueue(&q, i, i);
	}printf("111111");
	Solution(&q, num, NUM);
	
	return 0;
}