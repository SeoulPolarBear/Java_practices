#include<string.h>
#include<stdio.h>

int main(void) {

	char str[30] = { NULL };
    int length;
	
	if (str!= "exit" ) {

		printf("���ڿ� �Է�(�ִ� 30��):");
		gets_s(str, 30);

		length = strlen(str);
		printf("�Է��� ���ڿ��� %d����Ʈ�Դϴ�.\n", length);

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