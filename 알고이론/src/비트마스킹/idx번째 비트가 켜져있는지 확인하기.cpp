#include <iostream>

using namespace std;

int main() {
    int a = 18; // 10010
    int idx = 4;
    cout << ((a & (1 << idx)) > 0 ? "켜짐" : "꺼짐");
}