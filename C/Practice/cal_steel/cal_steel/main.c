#include<stdio.h>

int main() {
	double width, height, depth, length, ea, kg;
	printf("����, ����, �β�, ����, ����, ���� ������ �Է��Ͻÿ�.\n");
	scanf_s("%f", &width);
	scanf_s("%f", &height);
	scanf_s("%f", &depth);
	scanf_s("%f", &length);
	scanf_s("%f", &ea);
	scanf_s("%f", &kg);
	
	double weight = kg / ((width + height - (2 * depth)) * depth * length * ea / 1000);
	printf("%f", weight);
}



