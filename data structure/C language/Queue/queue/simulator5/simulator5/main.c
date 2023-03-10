#include "circular-queue.c"
int main(void)
{
	int minutes = 60;
	int total_wait = 0;
	int total_customers = 0;
	int service_time = 0;
	int delay_time = 0;
	int service_customer;
	Log log;
	QueueType queue;
	init_queue(&queue);


	srand(time(NULL));
	for (int clock = 0; clock < minutes; clock++) {
		printf("현재시각 = %d\n", clock);
		if ((rand() % 10) < 3) {
			element customer;
			customer.id = total_customers++;
			customer.arrival_time = clock;
			customer.service_time = rand() % 3 + 1;
			enqueue(&queue, customer);
			printf("고객 %d이 %d분에 들어옵니다. 업무처리시간 = %d분\n",
				customer.id, customer.arrival_time, customer.service_time);
		}
		if (service_time > 0) {
			printf("고객 %d 업무처리중입니다. \n", service_customer);
			service_time--;
		}
		else {
			if (!is_empty(&queue)) {
				element customer = dequeue(&queue);
				//Log log= enqueue(&queue, customer);
				service_customer = customer.id;
				service_time = customer.service_time;
				log.delay_time = clock - customer.arrival_time;
				printf("고객%d이 %d 분에 업무를 시작합니다. 대기시간은 %d 분이었습니다.\n",
					customer.id, delay_time);
				total_wait += delay_time;
			}
		}
	}
	printf("전체 대기 시간 = %dqns \n", total_wait);
	return 0;
}





