#include<string.h>
#include<stdio.h>

int main(void) {

    char str[30] = { NULL };// str 배열 선언 및 초기화
    int length;
    int r;
    char existence = 'N';// 공백이 있는지 판별할 판별 변수 선언 및 초기화 N 는 없고 Y는 있음을 표시
    char* p;//포인터 선언

    while (1) {//while을 이용하여 문자열 입력 반복

        printf("문자열 입력(최대 30자):");
        gets_s(str, 30);// 문자열 입력

                        /* exit일 경우 프로그램 종료*/
        if (str[0] == 'e' && str[1] == 'x' && str[2] == 'i' && str[3] == 't')
        {
            printf("프로그램을 종료합니다.");
            break;
        }
        /*문자열 바이트 출력*/
                 
         else
            length = strlen(str);
        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == ' ')
            {
                existence = 'Y';// 공백이 존재할 시 existence가 Y를 가르킨다.
                printf("공백이 포함된 문자열 입니다. 다시 입력해 주십시오.\n");
                break;// 공백이 포함된 문자열 이므로 다시 입력하게 출력 
            }
        }
            
            /*각 포인터가 가르키는 각 배열의 문자 출력*/
            if(existence == 'N'){// 공백이 없는 문자열이므로 아래 함수 수행 
            printf("입력한 문자열은 %d바이트입니다.\n", length);
            length = strlen(str);
            p = str;
            for (r = 0; r < length; r++) {
                printf("*(p+%d): %c\n", r, *p);
                p++;
                
            }
           
            }
             existence ='N' ; // 처음부터 다시 공백유무 확인을 위해 existence를 N으로 변경
        }


        return 0;
        }
       

        