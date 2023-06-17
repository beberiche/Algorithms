#include <iostream>
using namespace std;
int N, dp[50004];

int main() {
    cin >> N;
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= N; i++) {
        int ret = 987654321;
        for (int j = 1; j * j <= i; j++) {
            ret = min(ret, dp[i - j * j]);
        }
        dp[i] = ret + 1;
    }
    cout << dp[N];
}
