#include <iostream>
using namespace std;
int main() {
    // 비트를 킨다 => 1
    // 비트를 끈다 => 0

    int a = 18; // 10010
    int idx = 1;
    //  10010
    //& 11101
    //  -----
    //  10000
    cout << (a&=~(1<<idx));
}