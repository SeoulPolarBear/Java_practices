#include<stdio.h>
#include<stdlib.h>

void print_arr(int arr[], int len)
{
	for (int i = 0; i < len; i++)
	        printf("% 4d", arr[i]);
}
void make_arr(int arr[], int len)
{
	    for (int i = 0; i < len; i++)
		    arr[i] = rand() % 100;
	}
int main()
{
		    int numbers[50];
		    make_arr(numbers, 50);
		    print_arr(numbers, 50);
		    return 0;
		}