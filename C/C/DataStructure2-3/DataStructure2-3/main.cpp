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
	address addr;  // person 객체 안에 address 데이터가 들어간다.
} person;

void read_person(person* list);
void print_person(person* list2);
int main()
{
	person* p[20];
	p[0] = (person*)malloc(sizeof(person)); // malloc 코드 2 (2)와 동일, sizeof의 크기를 생각해 보세요.  
	read_person(p[0]);  // 주소 필드는 person->addr.city와 같이 접근
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
	printf("이름: %s", list2->name);
	printf(" (%d세)", list2->age);
	printf(" 주소: %s", list2->addr.city);
	printf(" %s", list2->addr.street);
	printf(" %s", list2->addr.detail);
}