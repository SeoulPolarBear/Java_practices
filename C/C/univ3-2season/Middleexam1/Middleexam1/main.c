#include<stdio.h>
#include<stdlib.h>
#define ROW 10 //행 개수 설정
#define COL 10 //열 개수 설정

int main(void) {
	int i, j, r; // i,j,r int 타입으로 선언
	int str[ROW][COL]; // 2차원 배열 str int 타입으로 선언

	/*for 문을 이용하여 각 배열 값에 0 or 1을 넣을 수 있게 하고
	 0은 20% 확률로 생성하도록 설정*/
	for (i = 0; i < ROW; i++)
	{
		for (j = 0; j < COL; j++) {
			r = rand() % 100;
			if (r<20)
				str[i][j] = 0;
			else
				str[i][j] = 1;
		} 
     }
	/*for 문을 이용하여 각 배열 값에 0인 배열에는 ★이
	1이 배열 값인 배열에는 . 을 생성하게 설정*/
	for (i = 0; i < ROW; i++)
	{
		for (j = 0; j < COL; j++) {
			if (str[i][j] == 0)
				printf(" ★");
			else 
				printf(" . ");
		}
		printf("\n"); /* 각 행의 배열이 모두 차면 
					  다음 행으로 줄바꿈 할 수 있게 처리*/
	}
}