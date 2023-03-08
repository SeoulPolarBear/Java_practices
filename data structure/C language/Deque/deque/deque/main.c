#include "deque.h"

int main(void)
{
	DequeType queue;
	element e;
	int command;
	init_deque(&queue);
	const char* cmd_str[] = { "add_front", "add_rear", "delete_front", "delete_rear" };
	printf("(1) add_front (2) add_rear \n(3) delete_front (4) delete_rear  (0) end  \n");
	//메뉴를 표시
	while (1) {
		printf("=> ");
		scanf_s("%d", &command);//명령을 받고 ex)1,2, 5
		if (command == 0) break;
		switch (command) {
		case ADD_F: scanf_s("%d", &e); add_front(&queue, e); break;
		case ADD_R: scanf_s("%d", &e); add_rear(&queue, e); break;
		case REMOVE_F: e = delete_front(&queue); break;
		case REMOVE_R: e = delete_rear(&queue); break;
		default: continue;
		}
		printf("%-13s", cmd_str[command - 1]);//우리가 받는거는 1부터 시작하므로 -1을 해준다.
		print_queue(&queue, command, e);
	}
	return 0;
}