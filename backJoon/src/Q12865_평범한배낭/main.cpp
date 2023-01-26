#include <bits/stdc++.h>
using namespace std;
int dp[100004];
int items[100004][2];
int N, K;
int main() {
    cin >> N >> K;
    for (int i = 1; i <= N; i++) {
        cin >> items[i][0] >> items[i][1];
        for (int j = K; j >= 1; j--)
            if (items[i][0] <= j)
                dp[j] = max(dp[j], dp[j - items[i][0]] + items[i][1]);
    }
    cout << dp[K];
}