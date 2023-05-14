
#include <iostream>
using namespace std;
int main() {
    // 최하위 켜져있는 비트 찾기
    int a = 24; // 10010
    int idx = (a&(-a));
    cout << idx;
}