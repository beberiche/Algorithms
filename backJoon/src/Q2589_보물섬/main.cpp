//
// Created by 김종현 on 2023/04/01.
//
#include <iostream>
#include <queue>
#include <vector>
#define f first
#define s second
using namespace std;
typedef pair<int, int> pi;
typedef pair<pi, int> pii;
int N, M,ans;
vector<vector<char>> v;
vector<vector<int>> visited;
vector<int> dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};

void input() {
    cin >> N >> M;
    v = vector<vector<char>>(N, vector<char>(M, '0'));
    string temp;
    for (int i = 0; i < N; i++) {
        cin >> temp;
        for (int j = 0; j < M; j++) {
            v[i][j] = temp[j];
        }
    }
}

int bfs(int r, int c) {
    queue<pii> q;
    q.push({{r, c}, 0});
    visited = vector<vector<int>> (N, vector<int>(M, 0));
    visited[r][c]++;
    int dist = 0;
    while (!q.empty()) {
        pii curr = q.front();
        q.pop();
        dist = max(dist, curr.s);
        for (int d = 0; d < 4; d++) {
            int nr = curr.f.f + dr[d];
            int nc = curr.f.s + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if (v[nr][nc] == 'W') continue;
            visited[nr][nc]++;
            q.push({{nr, nc}, curr.s + 1});
        }
    }

    return dist;
}

void solve() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (v[i][j] == 'L') {
                int dist = bfs(i, j);
                ans = max(ans, dist);
            }
        }
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}