#include "circular_q.h"
int main()
{
	QueueType queue;//원형큐 하나 설정
	element e;
	char token[10]/*, buf[10]*/;/*token은 명령어 ex)end, enq, deq, 
							buf는 집어 넣을 값enq에서 사용가능*/

	init_queue(&queue);
	while (1)
	{
		printf("= ");
		scanf_s("%s", token, 10);
		if (strcmp(token, "end") == 0) break;//end면 break 
		if (strcmp(token, "enq") == 0) {
			//scanf_s("%s", buf, 10);
			//e = buf[0];
			scanf_s("%d", &e);
			enqueue(&queue, e);
		}
		else {//deq
			e = dequeue(&queue);//꺼낸 요소 값
		}
		print_queue(&queue, (strcmp(token, "deq") == 0), e);//deq면 true, enq면 false
	}
	return 0;
}