#include<stdio.h>
#include <wchar.h>

int wcscmp_demo(const wchar_t* String1, const wchar_t* String2) {
	//������ �迭�� ������ �� �տ��� ���� �� �ƽ�Ű�ڵ� �������� �տ� �ִ� ���ڰ� �� ū ���� �ȴ�.(��, abc> abcefg, hgh < abc)
	//������ �迭 �߿� �ϳ��� ������ �� �迭�� �������� NULL(�ƽ�Ű �ڵ�δ� 0)�̹Ƿ� ���� �迭�� �� ū�� �ȴ�.
	for (int i = 0; i < wcslen(String1) + 1 && i < wcslen(String2) + 1;++i) {
		if (String1[i] == String2[i]) {
			if (wcslen(String1) == wcslen(String2)) {
				return 0;
			}
			else{ 
				continue; 
			}
			
		}
		else if (String1[i] > String2[i]) {
			return 1;
		}
		else /*if (String1[i] > String2[i])*/ {
			return -1;
		}
	}

}

int main() {
	wchar_t s[10] = L"yyyyy";
	wchar_t t[10] = L"�ѱ� ��ġ";
	printf("%d", wcscmp_demo(s, t));
}