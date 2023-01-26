#include<stdio.h>
#define size 100

void removespace(char* s); 
int char_count(char* s, char c);

int main(void) {
	char Alphabet; // a~z 까지 사용하려고 변수 Alphabet 선언
	char str[size]; //넉넉하게 배열 size는 100으로 설정
	int total; // 총 알파벳 개수를 나타내기위해 int 변수 선언
	printf("공백을 포함한 문자열을 입력하세요:");  
	gets_s(str, 100); // 공백을 포함한 문자열 입력
	removespace(str); // 공백 제거 후 문자열 출력
	printf("\n"); 
	/* 실행결과 출력*/
	for (Alphabet = 'a'; Alphabet <= 'z'; Alphabet++) {
		total = char_count(str, Alphabet);
		printf("%c:%d\n", Alphabet, total);
	}

}



/*공백을 제거한 문자열 출력*/
void removespace(char *s) {
	int i;
	for (i = 0; i < size; i++) {
		if (s[i] != ' ')
			printf("%c", s[i]);
	}
}
/*알파벳 개수 count*/
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

