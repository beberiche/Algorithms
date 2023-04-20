//
// Created by 김종현 on 2023/04/20.
//
#include <iostream>
#include <vector>
using namespace std;
int R, C, ans, visited[100],dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
vector<string> a;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> R >> C;
    string str;
    for (int i = 0; i < R; i++) {
        cin >> str;
        a.push_back(str);
    }
}

void solve(int r, int c, int dist) {
    visited[a[r][c]]++;
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
        if (visited[a[nr][nc]]) continue;
        solve(nr, nc, dist + 1);
    }
    visited[a[r][c]]--;
    ans = max(ans, dist);
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(0, 0, 1);
    output();
}