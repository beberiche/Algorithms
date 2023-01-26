#include <cstring>
#include <iostream>
using namespace std;
int T, N, M;
int arr[24], dp[10004];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        for (int i = 0; i < N; i++)
            cin >> arr[i];
        cin >> M;
        dp[0] = 1;
        for (int i = 0; i < N; i++)
            for (int j = arr[i]; j <= M; j++)
                dp[j] += dp[j - arr[i]];
        cout << dp[M] << "\n";
        memset(dp, 0, sizeof(dp));
    }
    return 0;
}