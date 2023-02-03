#include <iostream>
using namespace std;
int N, arr[2505], dp[2505];
int ans;
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
    }
}

void print() { cout << N - ans; }

void solve() {
    ans = 0;
    for (int i = 1; i < N; i++) {
        int cnt = 0;
        int curr = arr[i];
        for (int j = i + 1; j <= N; j++) {
            curr = arr[j] - curr;
            if (curr == 0) {
                cnt++;
            }
            ans = max(ans, cnt);
        }
    }
}
int main() {
    input();
    solve();
    print();
    return 0;
}