#include <iostream>
using namespace std;
int N, ans, cnt;

int main() {
    cin >> N;
    while (true) {
        if (N < (1 << cnt)) break;
        if (N & (1 << cnt++)) ans++;
    }
    cout << ans;
}