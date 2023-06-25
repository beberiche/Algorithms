#include <iostream>
using namespace std;
int N, a[1004][3], dp[1004][3];
void input() {
    cin >> N;
    for(int i=1; i<=N; i++) {
        for(int j=0; j<3; j++) {
            cin >> a[i][j];
        }
    }
}

void solve() {
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    for(int i=1; i<=N; i++) {
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + a[i][0];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + a[i][1];
        dp[i][2] = min(dp[i-1][1], dp[i-1][0]) + a[i][2];
    }
}

void output() {
    cout << min(dp[N][0], min(dp[N][1], dp[N][2]));
}

int main() {
    input();
    solve();
    output();
}