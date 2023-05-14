#include <iostream>
using namespace std;
int main() {
    int a = 18; // 10010
    int idx = 0;
    //  10010
    //| 11101
    //  -----
    //  11111
    cout << (a|=1<<idx);
}