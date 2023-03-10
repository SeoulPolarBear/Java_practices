#include "linkedlist.h"

void error(char* message)
{
	fprintf(stderr, "%s\n", message);
	exit(1);
}

ListNode* insert_first(ListNode* head, element value) {
	
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));
	p->data = value;
	p->link = head;
	head = p;
	return head;
}

ListNode* insert(ListNode* head, ListNode* pre, element value) {
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));
	p->data = value;
	if (head == NULL) {
		p->link = NULL;
		return p;
	}
	if (pre == NULL) {
		pre = get_last_node(head);
	}
	p->link = pre->link;
	pre->link = p;
	return head;
}

ListNode* get_last_node(ListNode* head)
{
	ListNode* cur = head;
	if (cur == NULL || cur->link == NULL)
		return cur;
	while (cur->link != NULL)
		cur = cur->link;
	return cur;
}

ListNode* delete_first(ListNode* head) {
	ListNode* removed;
	if (head == NULL) return NULL;
	removed = head;
	head = removed->link;
	free(removed);
	return head;
}
ListNode* delete_(ListNode* head, ListNode* pre) {
	if (head == NULL || head->link == NULL) return NULL;
	if (pre == NULL) {
		pre = head;
		while (pre->link->link != NULL) {
			pre = pre->link;
		}
	}
		ListNode* removed;
		removed = pre->link;
		pre->link = removed->link;
		free(removed);
		return head;
}
void print_list(const char* cmd, ListNode* head)
{
	printf("%-10s[", cmd);
	for (ListNode* p = head; p != NULL; p = p->link)
		printf(" %2d ", p->data);
	printf("]\n");
}

ListNode* create(int start, int end, int step) {
	ListNode* head = (ListNode*)malloc(sizeof(ListNode));
	ListNode* p;
	int Num = end - (end - start) % step;

	head->link = NULL;
	while (Num >= start) {
		p = (ListNode*)malloc(sizeof(ListNode));
		p->data = Num;
		p->link = head->link;
		head->link = p;
		Num -= step;
	}
	return head->link;
}

ListNode* get_at(ListNode* head, int at) {
	ListNode* p = (ListNode*)malloc(sizeof(ListNode));
	p = head;
	if (head == NULL) return NULL;
	if (head->link == NULL) return head;
	/*while (p->link != NULL)*/ 
	if (at == 0) {
		return p;
	}
	for(int i = 0; i<at; i++){
		p = p->link;
	}
	return p;
}

ListNode* reverse(ListNode* head) {
	ListNode* p, * q, * r;

	p = head;
	q = NULL;
	while (p!= NULL) {
		r = q;
		q = p;
		p = p->link;
		q->link = r;
	}
	return q;
}