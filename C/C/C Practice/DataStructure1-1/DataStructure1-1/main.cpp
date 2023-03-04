#include <stdio.h>
int main()
{
    int N;// 일력받은 N
    int T;// 구구단 곱셈 값
    scanf("%d", &N);
    if (N >= 1 && N <= 9) {
        for (int i = 1; i < 10; i++) {
            T = N * i;
            printf("% d * %d = %d\n", N, i, T);
        }
    }
    else   // 4의 배수 중 100의 배수가 아니거나 400의 배수면
    {
        printf("잘못된 입력 방식입니다.다시 입력해 주세요.");
    }

        return(0);
    }
