#include<stdio.h>
#define size 100

void removespace(char* s); 
int char_count(char* s, char c);

int main(void) {
	char Alphabet; // a~z ���� ����Ϸ��� ���� Alphabet ����
	char str[size]; //�˳��ϰ� �迭 size�� 100���� ����
	int total; // �� ���ĺ� ������ ��Ÿ�������� int ���� ����
	printf("������ ������ ���ڿ��� �Է��ϼ���:");  
	gets_s(str, 100); // ������ ������ ���ڿ� �Է�
	removespace(str); // ���� ���� �� ���ڿ� ���
	printf("\n"); 
	/* ������ ���*/
	for (Alphabet = 'a'; Alphabet <= 'z'; Alphabet++) {
		total = char_count(str, Alphabet);
		printf("%c:%d\n", Alphabet, total);
	}

}



/*������ ������ ���ڿ� ���*/
void removespace(char *s) {
	int i;
	for (i = 0; i < size; i++) {
		if (s[i] != ' ')
			printf("%c", s[i]);
	}
}
/*���ĺ� ���� count*/
int char_count(char* s, char c) {
	int i;
	int count = 0 ;
	for(i=0; i<strlen(s); i++)
	{
		if (s[i] == c) {
			count +=1;
		}
	}
	return count;
}

