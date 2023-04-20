//
// Created by 김종현 on 2023/04/16.
//
#include <iostream>
#include <queue>

using namespace std;
int N, M, r1, c1, r2, c2, arr[302][302], visited[302][302], ans, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
void input() {
    cin >> N >> M >> r1 >> c1 >> r2 >> c2;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < M; j++) {
            if ((i == r1 - 1 && j == c1 - 1) || (i == r2 - 1 && j == c2 - 1)) continue;
            arr[i][j] = str[j] - '0';
        }
    }
}

void solve(int r, int c) {
    queue<pair<int, int>> q;
    visited[r][c]++;
    q.push({r, c});
    while (true) {
        ans++;
        queue<pair<int, int>> q2;
        while (!q.empty()) {
            pair<int, int> curr = q.front();
            q.pop();
            for (int d = 0; d < 4; d++) {
                int nr = curr.first + dr[d];
                int nc = curr.second + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (nr == r2 - 1 && nc == c2 - 1) return;
                visited[nr][nc]++;
                if (arr[nr][nc]) {
                    arr[nr][nc] = 0;
                    q2.push({nr, nc});
                } else {
                    q.push({nr, nc});
                }
            }
        }
        q = q2;
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(r1 - 1, c1 - 1);
    output();
}