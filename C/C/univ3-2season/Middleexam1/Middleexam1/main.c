#include<stdio.h>
#include<stdlib.h>
#define ROW 10 //�� ���� ����
#define COL 10 //�� ���� ����

int main(void) {
	int i, j, r; // i,j,r int Ÿ������ ����
	int str[ROW][COL]; // 2���� �迭 str int Ÿ������ ����

	/*for ���� �̿��Ͽ� �� �迭 ���� 0 or 1�� ���� �� �ְ� �ϰ�
	 0�� 20% Ȯ���� �����ϵ��� ����*/
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
	/*for ���� �̿��Ͽ� �� �迭 ���� 0�� �迭���� ����
	1�� �迭 ���� �迭���� . �� �����ϰ� ����*/
	for (i = 0; i < ROW; i++)
	{
		for (j = 0; j < COL; j++) {
			if (str[i][j] == 0)
				printf(" ��");
			else 
				printf(" . ");
		}
		printf("\n"); /* �� ���� �迭�� ��� ���� 
					  ���� ������ �ٹٲ� �� �� �ְ� ó��*/
	}
}