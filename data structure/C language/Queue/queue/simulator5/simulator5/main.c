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
		printf("����ð� = %d\n", clock);
		if ((rand() % 10) < 3) {
			element customer;
			customer.id = total_customers++;
			customer.arrival_time = clock;
			customer.service_time = rand() % 3 + 1;
			enqueue(&queue, customer);
			printf("�� %d�� %d�п� ���ɴϴ�. ����ó���ð� = %d��\n",
				customer.id, customer.arrival_time, customer.service_time);
		}
		if (service_time > 0) {
			printf("�� %d ����ó�����Դϴ�. \n", service_customer);
			service_time--;
		}
		else {
			if (!is_empty(&queue)) {
				element customer = dequeue(&queue);
				//Log log= enqueue(&queue, customer);
				service_customer = customer.id;
				service_time = customer.service_time;
				log.delay_time = clock - customer.arrival_time;
				printf("��%d�� %d �п� ������ �����մϴ�. ���ð��� %d ���̾����ϴ�.\n",
					customer.id, delay_time);
				total_wait += delay_time;
			}
		}
	}
	printf("��ü ��� �ð� = %dqns \n", total_wait);
	return 0;
}





