#include<stdio.h>
#include <corecrt_malloc.h>

typedef struct tag {
	char name[20];
	int age;
} person;

void read_person(person* list);
void print_person(person* list2);


int main()
{
	person *people[10];
	people[0] =(person *)malloc(sizeof(person));
	read_person(people[0]);
	print_person(people[0]);
	return 0;
}


void read_person(person* list) {
	scanf("%s", list->name);//name 자체가 주소이므로 &는 넣지 않는다
	scanf("%d", &list->age);
}

void print_person(person* list2) {
	printf("이름: %s", list2->name);
	printf(" (%d세)", list2->age);

}
