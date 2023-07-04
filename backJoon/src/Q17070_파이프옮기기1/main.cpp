#include <iostream>

using namespace std;
int N, a[18][18], dp[18][18][3];

// 3차원 dp
// [0] : 가로, [1] : 세로, [2] : 대각선
void input() {
    cin >> N;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> a[i][j];
        }
    }
}

void solve() {
    dp[1][2][0] = 1;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (a[i][j + 1] == 0) dp[i][j + 1][0] += dp[i][j][0];
            if (a[i + 1][j + 1] == 0 && a[i][j + 1] == 0 && a[i + 1][j] == 0) dp[i + 1][j + 1][2] += dp[i][j][0];

            if (a[i + 1][j] == 0) dp[i + 1][j][1] += dp[i][j][1];
            if (a[i + 1][j + 1] == 0 && a[i][j + 1] == 0 && a[i + 1][j] == 0) dp[i + 1][j + 1][2] += dp[i][j][1];

            if (a[i][j + 1] == 0) dp[i][j + 1][0] += dp[i][j][2];
            if (a[i + 1][j] == 0) dp[i + 1][j][1] += dp[i][j][2];
            if (a[i + 1][j + 1] == 0 && a[i][j + 1] == 0 && a[i + 1][j] == 0) dp[i + 1][j + 1][2] += dp[i][j][2];
        }
    }
}

void output() {
    cout << dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
}

int main() {
    input();
    solve();
    output();
}