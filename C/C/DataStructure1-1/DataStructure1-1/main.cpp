#include <stdio.h>
int main()
{
    int N;// �Ϸ¹��� N
    int T;// ������ ���� ��
    scanf("%d", &N);
    if (N >= 1 && N <= 9) {
        for (int i = 1; i < 10; i++) {
            T = N * i;
            printf("% d * %d = %d\n", N, i, T);
        }
    }
    else   // 4�� ��� �� 100�� ����� �ƴϰų� 400�� �����
    {
        printf("�߸��� �Է� ����Դϴ�.�ٽ� �Է��� �ּ���.");
    }

        return(0);
    }
