#include<stdio.h>
#include<stdlib.h>
#define size 30;

int main(void) {

	char str[30];
	int length;

	printf("���ڿ� �Է�(�ִ� 30��):");
	scanf("%s", &str);
	printf("%s\n", str);

	length = strlen(str);
	printf("�Է��� ���ڿ��� %d����Ʈ�Դϴ�.", length);


}