//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <vector>

using namespace std;
int R, C, K, ans;
vector<vector<char>> v;
vector<vector<int>> visited;
const int dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};

void input() {
    cin >> R >> C >> K;
    v = vector<vector<char>>(R, vector<char>(C, 0));
    string str;
    for (int i = 0; i < R; i++) {
        cin >> str;
        for (int j = 0; j < C; j++) {
            v[i][j] = str[j];
        }
    }
}

void dfs(int r, int c, int cnt) {
    if (r == 0 && c == C - 1 && cnt == K) {
        ans++;
        return;
    }
    if (cnt > K) {
        return;
    }
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
        if (v[nr][nc] == 'T') continue;
        if (visited[nr][nc]) continue;
        visited[nr][nc]++;
        dfs(nr, nc, cnt + 1);
        visited[nr][nc]--;
    }
}

void solve(int r, int c) {
    visited = vector<vector<int>>(R, vector<int>(C, 0));
    visited[r][c]++;
    dfs(r, c, 1);
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(R - 1, 0);
    output();
}