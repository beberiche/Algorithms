
#include <iostream>
using namespace std;
int main() {
    // idx번 비트 XOR 연산
    // idx번째가 켜져있다면 끄고 1 => 0
    // idx번째가 꺼져있다면 키고 0 => 1
    int a = 18; // 10010
    int idx = 1;
    //  10010
    //^ 00010
    //  -----
    //  10000
    cout << (a^=(1<<idx));
}