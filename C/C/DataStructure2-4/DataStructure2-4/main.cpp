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
	address* add;     // person 객체 안에 address 객체의 포인터가 들어간다.
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
	// malloc 코드 2 (2)와 동일, sizeof의 크기를 생각해 보세요.  
	read_person(p[0]);  // 주소 필드는 person->addr.city와 같이 접근
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
	
	printf("이름: %s", list2->name);
	printf(" (%d세)", list2->age);
	printf(" 주소: %s", list2->add->city);
	printf(" %s", list2->add->street);
	printf(" %s", list2->add->detail);
}