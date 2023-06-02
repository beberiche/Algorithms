#include <iostream>
#include <algorithm>
using namespace std;
string a[4];
int N, M, ans;

void input() {
    cin >> N >> M;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
}

void solve() {
    for (int i = 0; i < (1 << (N * M)); i++) {
        // 가로
        int sum = 0;
        for (int j = 0; j < N; j++) {
            int curr = 0;
            for (int k = 0; k < M; k++) {
                if (!(i & (1 << j * M + k))) {
                    curr = curr * 10 + (int) (a[j][k] - '0');
                } else {
                    sum += curr, curr = 0;
                }
            }
            sum += curr;
        }

        // 세로
        for (int k = 0; k < M; k++) {
            int curr = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j * M + k))) {
                    curr = curr * 10 + (int) (a[j][k] - '0');
                } else {
                    sum += curr, curr = 0;
                }
            }
            sum+= curr;
        }
        ans = max(ans, sum);
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}