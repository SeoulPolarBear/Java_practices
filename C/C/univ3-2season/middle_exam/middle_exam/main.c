#include<stdio.h>
#include<stdlib.h>
#define size 30;

int main(void) {

	char str[30];
	int length;

	printf("문자열 입력(최대 30자):");
	scanf("%s", &str);
	printf("%s\n", str);

	length = strlen(str);
	printf("입력한 문자열은 %d바이트입니다.", length);


}