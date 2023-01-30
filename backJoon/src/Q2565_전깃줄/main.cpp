#include <algorithm>
#include <iostream>
using namespace std;
typedef pair<int, int> p;
p a1[104];
int dp[104], N;
bool cmp(p n1, p n2) { return n1.second < n2.second; }
int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a1[i].first >> a1[i].second;
    }

    sort(a1, a1 + N, cmp);
    int ans = 0;
    for (int i = 0; i < N; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (a1[j].first < a1[i].first)
                dp[i] = max(dp[i], dp[j] + 1);
        }
        ans = max(ans, dp[i]);
    }
    cout << N - ans;
}