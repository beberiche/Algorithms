#include <iostream>
using namespace std;
int T, W, a[1004], dp[3][1004][34], ans = -1;

void input() {
    cin >> T >> W;
    for (int i = 1; i <= T; i++) {
        cin >> a[i];
    }
}

void go() {
    dp[1][1][0] = a[1] == 1 ? 1 : 0;
    dp[2][1][1] = a[1] == 1 ? 0 : 1;

    for (int i = 2; i <= T; i++) {
        for (int j = 0; j <= W; j++) {
            if (a[i] == 1) {
                dp[1][i][j] = max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                dp[2][i][j] = max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
            } else {
                dp[1][i][j] = max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                dp[2][i][j] = max(dp[1][i - 1][j - 1], dp[2][i - 1][j]) + 1;
            }
        }
    }

    for (int i = 0; i <= W; i++) {
        for (int j = 1; j <= 2; j++) {
            ans = max(ans, dp[j][T][i]);
        }
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    go();
    output();
}