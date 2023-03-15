//
// Created by 김종현 on 2023/03/15.
//
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;
typedef pair<int, int> pi;
int N, M, arr[104][104], c_cnt, cnt, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, 1, 0, -1};
bool visited[104][104];
vector<int> v;

void input() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) c_cnt++;
        }
    }
    v.push_back(c_cnt);
}

void solve() {
    memset(visited, false, sizeof(visited));
    queue<pi> q;
    q.push({0, 0});
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        if (arr[curr.first][curr.second] == 1) {
            arr[curr.first][curr.second] = 0;
            c_cnt--;
            continue;
        }
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc]) continue;
            visited[nr][nc] = true;
            q.push({nr, nc});
        }
    }
    v.push_back(c_cnt);
}

void output() {
    cout << cnt << "\n";
    cout << v[v.size() - 2];
}

int main() {
    input();
    while (c_cnt != 0) {
        cnt++;
        solve();
    }
    output();
}