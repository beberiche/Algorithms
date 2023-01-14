#include <bits/stdc++.h>
using namespace std;

#define MAX 100001
int prefix[MAX];
int N, K, num, ans = -987654321;
int main() {
    cin >> N >> K;

    for (int i = 1; i <= N; i++) {
        cin >> num;
        prefix[i] = prefix[i - 1] + num;
    }

    for (int i = 1; i + K <= N; i++) {
        ans = max(ans, prefix[i + K] - prefix[i]);
    }
    cout << ans;
}
