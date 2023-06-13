#include <iostream>
using namespace std;
int a[1004][3], dp[3][1004][3];
int N, ans;
const int MAX = 1000 * 1000 + 4;

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> a[i][j];
        }
    }
}

void go() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            dp[i][0][j] = i == j ? a[0][j] : MAX;
        }

        for (int j = 1; j < N; j++) {
            dp[i][j][0] = min(dp[i][j - 1][1], dp[i][j - 1][2]) + a[j][0];
            dp[i][j][1] = min(dp[i][j - 1][0], dp[i][j - 1][2]) + a[j][1];
            dp[i][j][2] = min(dp[i][j - 1][1], dp[i][j - 1][0]) + a[j][2];
        }
    }
}

void output() {
    ans = MAX;
    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
            if(i!=j) ans = min(dp[i][N-1][j], ans);
        }
    }
    cout << ans;
}

int main() {
    input();
    go();
    output();
}