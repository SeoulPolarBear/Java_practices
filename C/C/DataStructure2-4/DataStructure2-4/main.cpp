#include<stdio.h>
#include<malloc.h>

typedef struct addr {
	char* city;
	char* street;
	char* detail;
} address;
typedef struct tag {
	char* name;
	int age;
	address* add;     // person ��ü �ȿ� address ��ü�� �����Ͱ� ����.
} person;

void read_person(person* list);
void print_person(person* list2);
int main()
{
	person* p[20];
	p[0] = (person*)malloc(sizeof(person)); 
	/*char* name= (char*)malloc(sizeof(char));
	address* addr = (address *)malloc(sizeof(address));
	char* city = (char*)malloc(sizeof(char));
	char* street = (char*)malloc(sizeof(char));
	char* detail = (char*)malloc(sizeof(char));*/
	// malloc �ڵ� 2 (2)�� ����, sizeof�� ũ�⸦ ������ ������.  
	read_person(p[0]);  // �ּ� �ʵ�� person->addr.city�� ���� ����
	print_person(p[0]);
	return 0;
}

void read_person(person* list) {
	list->add = (address*)malloc(sizeof(address));
	list->name = (char*)malloc(sizeof(char));
	list->add->city = (char*)malloc(sizeof(char));
	list->add->street = (char*)malloc(sizeof(char));
	list->add->detail = (char*)malloc(sizeof(char));
	
	scanf("%s", list->name);
	scanf("%d", &list->age);
	scanf("%s", list->add->city);
	scanf("%s", list->add->street);
	scanf("%s", list->add->detail);
}

void print_person(person* list2) {
	
	printf("�̸�: %s", list2->name);
	printf(" (%d��)", list2->age);
	printf(" �ּ�: %s", list2->add->city);
	printf(" %s", list2->add->street);
	printf(" %s", list2->add->detail);
}