#pragma once
#include<stdio.h>
#include <stdlib.h>


#define CREATE 1
#define APPEND 2
#define PUSH 3
#define POP 4
#define INSERTAT 5
#define VALUEAT 6
#define DELETEAT 7
#define END 8

typedef int element;
typedef struct ListNode{
	element data;
	struct ListNode* link;
}ListNode;

void error(char* message);
ListNode* insert_first(ListNode* head, element value);
ListNode* insert(ListNode* head, ListNode* pre, element value);
ListNode* get_last_node(ListNode* head);
ListNode* delete_first(ListNode* head);
ListNode* delete_(ListNode* head, ListNode* pre);
void print_list(const char* cmd, ListNode* head);
ListNode* create(int start, int end, int step);
ListNode* get_at(ListNode* head, int at);
