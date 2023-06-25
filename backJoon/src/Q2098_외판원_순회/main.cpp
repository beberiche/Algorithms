#include <iostream>
using namespace std;
int N, dist[16][16], dp[16][1 << 16], INF = 987654321, ans;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> dist[i][j];
        }
    }
}

int solve(int start, int visited) {
    if (visited == (1 << N) - 1) {
        return dist[start][0] ? dist[start][0] : INF;
    }

    if (dp[start][visited] != 0) return dp[start][visited];

    dp[start][visited] = INF;

    for (int i = 0; i < N; i++) {
        if (dist[start][i] == 0) continue;
        if (visited & (1 << i)) continue;

        int ret = solve(i, visited | 1<<i);
        dp[start][visited] = min(dp[start][visited], dist[start][i] + ret);
    }

    return dp[start][visited];
}

void output() {
    cout << ans;
}

int main() {
    input();
    ans = solve(0, 1);
    output();
}