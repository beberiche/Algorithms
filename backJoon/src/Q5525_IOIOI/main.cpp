#include <iostream>

using namespace std;
int N, M;
string str;

int main() {
    cin >> N >> M >> str;
    int ans = 0;
    int L = 0;
    while (L < str.size()) {
        while (str[L] != 'I' && L < str.size()) L++;
        if (str.size() == L) break;
        int cnt = 0;
        while (str[L + 1] == 'O' && str[L + 2] == 'I') {
            cnt++;
            if (cnt == N) {
                cnt--;
                ans++;
            }
            L += 2;
        }
        L++;
    }

    cout << ans;
}