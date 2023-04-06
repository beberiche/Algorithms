//
// Created by 김종현 on 2023/04/01.
//
#include <iostream>
#include <queue>
#include <vector>

#define f first
#define s second
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vii;
typedef pair<int, int> pi;
vector<pi> temp;
vi dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
vii v, visited;
int N, L, R, sum, ans;

void input() {
    cin >> N >> L >> R;
    v = vii(N, vi(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> v[i][j];
        }
    }
}

void bfs(int r, int c) {
    queue<pi> q;
    q.push({r, c});
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.f + dr[d];
            int nc = curr.s + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (visited[nr][nc]) continue;
            if (L > abs(v[curr.f][curr.s] - v[nr][nc]) || R < abs(v[curr.f][curr.s] - v[nr][nc])) continue;
            visited[nr][nc]++;
            q.push({nr, nc});
            temp.push_back({nr, nc});
            sum += v[nr][nc];
        }
    }
}

void solve() {
    while (true) {
        visited = vii(N, vi(N, 0));
        bool check = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    temp.clear();
                    temp.push_back({i,j});
                    sum = v[i][j];
                    visited[i][j]++;
                    bfs(i, j);
                    if (temp.size() > 1) {
                        int avg = sum / temp.size();
                        for (int i = 0; i < temp.size(); i++) {
                            v[temp[i].f][temp[i].s] = avg;
                            check = true;
                        }
                    }
                }
            }
        }
        if (!check) break;
        ans++;
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