#include<stdio.h>
#include <wchar.h>

int wcscmp_demo(const wchar_t* String1, const wchar_t* String2) {
	//각각의 배열의 값들을 비교 앞에서 부터 비교 아스키코드 기준으로 앞에 있는 문자가 더 큰 수가 된다.(즉, abc> abcefg, hgh < abc)
	//각각의 배열 중에 하나가 끝나면 그 배열의 마지막은 NULL(아스키 코드로는 0)이므로 끝난 배열이 더 큰게 된다.
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
	wchar_t t[10] = L"한글 패치";
	printf("%d", wcscmp_demo(s, t));
}