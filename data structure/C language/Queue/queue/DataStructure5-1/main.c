#include "circular_q.h"
int main()
{
	QueueType queue;//����ť �ϳ� ����
	element e;
	char token[10]/*, buf[10]*/;/*token�� ��ɾ� ex)end, enq, deq, 
							buf�� ���� ���� ��enq���� ��밡��*/

	init_queue(&queue);
	while (1)
	{
		printf("= ");
		scanf_s("%s", token, 10);
		if (strcmp(token, "end") == 0) break;//end�� break 
		if (strcmp(token, "enq") == 0) {
			//scanf_s("%s", buf, 10);
			//e = buf[0];
			scanf_s("%d", &e);
			enqueue(&queue, e);
		}
		else {//deq
			e = dequeue(&queue);//���� ��� ��
		}
		print_queue(&queue, (strcmp(token, "deq") == 0), e);//deq�� true, enq�� false
	}
	return 0;
}