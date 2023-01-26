#include<string.h>
#include<stdio.h>

int main(void) {

	char str[30] = { NULL };
    int length;
	
	if (str!= "exit" ) {

		printf("문자열 입력(최대 30자):");
		gets_s(str, 30);

		length = strlen(str);
		printf("입력한 문자열은 %d바이트입니다.\n", length);

		pointer(str);

	}
}


void pointer(char str) {
	int r;
	int length;
	char* p;
	length = strlen(str);
	p = str;
	for (r = 0; r < length; r++) {
		printf("*(p+%d): %c\n", r, *p);
		p++;
	}
}