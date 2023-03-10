#include "pizza.h"
// ���� �Լ�
void error(char* message)
{
	fprintf(stderr, "%s\n", message);//error �޽���
	exit(1);//�׸��� ���� ����
}

// ���� ���� ���� �Լ�
void init_queue(QueueType* q)//�ʱ�ȭ �����ִ� �Լ�
{
	q->front = q->rear = 0;/*����ť������ -1�� ������ ���� ť������ 0���� ����
							��ĭ ���̷� �ʱ�ȭ�� �����ֱ� ����*/
}

// ���� ���� ���� �Լ�
int is_empty(QueueType* q)
{
	return (q->front == q->rear);
}

// ��ȭ ���� ���� �Լ�
int is_full(QueueType* q)//rear�� ��ĭ �� ���� front �̴�.
{
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

// ���� �Լ�
void enqueue(QueueType* q, element item)
{
	if (is_full(q))
		error("ť�� ��ȭ�����Դϴ�");
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;//q->�տ� ++�� ������ ��ó�� %�� �̿��Ѱ� ����ť�̴�.
}

// ���� �Լ�
element dequeue(QueueType* q)
{
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];/*��� �������� ����Ų��: ������,
	���� �ϳ� ������Ű�� �� ���� ����*/
}

// ���� �Լ�
element peek(QueueType* q)
{
	if (is_empty(q))
		error("ť�� ��������Դϴ�");
	return q->data[(q->front + 1) % MAX_QUEUE_SIZE];/*���� ���� ����Ű�Ƿ�
													������ ���� ���� front ���� ����
													�����ֱ� ���ؼ� 1�� ���Ѵ�.*/
}

// ����ť ��� �Լ�
/*void print_queue(QueueType* q, int b_enq, element e)//deq�� true, enq�̸� false
{//�տ� ��ɹ��� ����. �״��� �׿� ���� print ����
	printf("\t");
	for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
		if (i == (q->front + 1) % MAX_QUEUE_SIZE) printf("<");//front�� <
		else printf(" ");
		if (i <= q->front && q->front < q->rear)
			printf("_");  //  i <<  --
		else if (q->front < i && i <= q->rear)
			printf("%d", q->data[i]);  // << i --
		else if (i <= q->rear && q->rear < q->front)
			printf("%d", q->data[i]);  //  i -- ___ <<
		else if (i > q->front && q->rear < q->front)
			printf("%d", q->data[i]);  //  -- ___ << i
		else
			printf("_");  //  i <<  --
		if (i == q->rear) printf("-");//rear�� -
		else
			printf(" ");
	}
	printf("  %s[%d]\n", b_enq ? "����" : "�߰�", e);//b_enq�� true, false�� ���⼭ ���
}*/