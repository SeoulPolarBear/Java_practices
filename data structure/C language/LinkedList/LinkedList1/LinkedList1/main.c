#include "linkedlist.h"

const char* cmdstr[] = { "create3", "append1", "push1", "pop", "insertat2",
					"valueat1", "deleteat1", "end" };
const char* text = { "잘못된 입력입니다." };
void main()
{
	element e;
	int index;
	ListNode* now;
	for (int i = 0; i < 8; i++) {
		printf("(%d) %-9s", i + 1, cmdstr[i]);
		if (i % 3 == 2) printf("\n");
	}
	printf("\n");
	ListNode* head = NULL, * result = NULL, * pre;

	int menu = 1;
	int start = 10, end = 100, step = 12, at;
	head = create(start, end, step);
	print_list(cmdstr[menu - 1], head);


	while (menu != END) {
		printf(">> "); scanf_s("%d", &menu);
		switch (menu) {
		case CREATE:
			scanf_s("%d %d %d", &start, &end, &step);
			head = create(start, end, step);
			break;
		case APPEND:
			scanf_s("%d", &e);
			head = insert(head, NULL, e);
			break;
		case PUSH:
			scanf_s("%d", &e);
			head = insert_first(head, e);
			break;
		case POP:
			head = delete_first(head);
			break;
		case INSERTAT:
			scanf_s("%d %d", &index ,&e);
			if (index == 0)
				head = insert_first(head, e);
			else if ((end - start) / step >= index && index > 0) {
				now = get_at(head, index - 1);
				head = insert(head, now, e);
			}
			else
				error(text);
			break;
			case VALUEAT:
			scanf_s("%d", &index);
			now=get_at(head, index);
			printf("%d번의 데이타 : %d\n", index, now->data);
				break;
		case DELETEAT:
			scanf_s("%d", &index);
			if (index == 0)
				head = delete_first(head);
			else if ((end - start) / step >= index && index > 0) {
				now = get_at(head, index - 1);
				head = delete_(head, now);
			}
			else
				error(text);
				break;
		case END: break;
		}
		print_list(cmdstr[menu - 1], head);
	}
}


