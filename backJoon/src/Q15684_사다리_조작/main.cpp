//
// Created by 김종현 on 2023/04/22.
//
#include <iostream>
using namespace std;
const int INF = 987654321;
int N, M, H, ans = INF, visited[34][34];

bool check() {
    for (int i = 1; i <= N; i++) {
        int curr = i;
        for (int j = 1; j <= H; j++) {
            if (visited[j][curr]) curr++;
            else if (visited[j][curr - 1]) curr--;
        }
        if (curr != i) return false;
    }
    return true;
}

void solve(int idx, int cnt) {
    if (cnt > 3) return;
    if (cnt >= ans) return;
    if (check()) {
        ans = min(ans, cnt);
        return;
    }
    for (int i = idx; i <= H; i++) {
        for (int j = 1; j <= N; j++) {
            if (visited[i][j]) continue;
            if (visited[i][j - 1] || visited[i][j + 1]) continue;
            visited[i][j] = 1;
            solve(i, cnt + 1);
            visited[i][j] = 0;
        }
    }
}

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> M >> H;
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        visited[a][b] = 1;
    }
}

void output() {
    cout << (ans == INF ? -1 : ans);
}

int main() {
    input();
    solve(1, 0);
    output();
}