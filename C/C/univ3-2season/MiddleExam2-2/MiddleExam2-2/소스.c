#include<string.h>
#include<stdio.h>

int main(void) {

    char str[30] = { NULL };// str �迭 ���� �� �ʱ�ȭ
    int length;
    int r;
    char existence = 'N';// ������ �ִ��� �Ǻ��� �Ǻ� ���� ���� �� �ʱ�ȭ N �� ���� Y�� ������ ǥ��
    char* p;//������ ����

    while (1) {//while�� �̿��Ͽ� ���ڿ� �Է� �ݺ�

        printf("���ڿ� �Է�(�ִ� 30��):");
        gets_s(str, 30);// ���ڿ� �Է�

                        /* exit�� ��� ���α׷� ����*/
        if (str[0] == 'e' && str[1] == 'x' && str[2] == 'i' && str[3] == 't')
        {
            printf("���α׷��� �����մϴ�.");
            break;
        }
        /*���ڿ� ����Ʈ ���*/
                 
         else
            length = strlen(str);
        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == ' ')
            {
                existence = 'Y';// ������ ������ �� existence�� Y�� ����Ų��.
                printf("������ ���Ե� ���ڿ� �Դϴ�. �ٽ� �Է��� �ֽʽÿ�.\n");
                break;// ������ ���Ե� ���ڿ� �̹Ƿ� �ٽ� �Է��ϰ� ��� 
            }
        }
            
            /*�� �����Ͱ� ����Ű�� �� �迭�� ���� ���*/
            if(existence == 'N'){// ������ ���� ���ڿ��̹Ƿ� �Ʒ� �Լ� ���� 
            printf("�Է��� ���ڿ��� %d����Ʈ�Դϴ�.\n", length);
            length = strlen(str);
            p = str;
            for (r = 0; r < length; r++) {
                printf("*(p+%d): %c\n", r, *p);
                p++;
                
            }
           
            }
             existence ='N' ; // ó������ �ٽ� �������� Ȯ���� ���� existence�� N���� ����
        }


        return 0;
        }
       

        