#include<stdio.h>
#include <malloc.h>

typedef struct addr {
	char city[20];
	char street[20];
	char detail[20];
} address;
typedef struct tag {
	char name[20];
	int age;
	address addr;  // person ��ü �ȿ� address �����Ͱ� ����.
} person;

void read_person(person* list);
void print_person(person* list2);
int main()
{
	person* p[20];
	p[0] = (person*)malloc(sizeof(person)); // malloc �ڵ� 2 (2)�� ����, sizeof�� ũ�⸦ ������ ������.  
	read_person(p[0]);  // �ּ� �ʵ�� person->addr.city�� ���� ����
	print_person(p[0]);
	return 0;
}

void read_person(person* list) {
	scanf("%s", list->name);
	scanf("%d", &list->age);
	scanf("%s", list->addr.city);
	scanf("%s", list->addr.street);
	scanf("%s", list->addr.detail);
}

void print_person(person* list2) {
	printf("�̸�: %s", list2->name);
	printf(" (%d��)", list2->age);
	printf(" �ּ�: %s", list2->addr.city);
	printf(" %s", list2->addr.street);
	printf(" %s", list2->addr.detail);
}