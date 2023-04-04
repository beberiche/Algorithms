//
// Created by 김종현 on 2023/04/03.
//
#include <iostream>
#include <vector>
#include <queue>

#define f first
#define s second
using namespace std;
int N, M, ans = 0;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int, int> pi;
typedef pair<pi, int> pii;
vvi v, fire_v, visited;
pi P;
vi dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};


void input() {
    cin >> N >> M;
    v = vvi(N, vi(M, 0));
    visited = vvi(N, vi(M, 0));
    fire_v = vvi(N, vi(M, 0));
    string str;
    queue<pii> fq;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < M; j++) {
            if (str[j] == '.') v[i][j] = 0;
            else if (str[j] == 'J') {
                v[i][j] = 1;
                P = {i, j};
            } else if (str[j] == 'F') {
                v[i][j] = 2;
                fire_v[i][j] = 1;
                fq.push({{i, j}, 1});
            } else v[i][j] = 3;

            if (fire_v[i][j] == 0) fire_v[i][j] = 3005;
        }
    }

    while (!fq.empty()) {
        pii curr = fq.front();
        fq.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.f.f + dr[d];
            int nc = curr.f.s + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (v[nr][nc] == 3) continue;
            if (fire_v[nr][nc] > curr.s + 1) {
                fire_v[nr][nc] = curr.s + 1;
                fq.push({{nr, nc}, curr.s + 1});
            }
        }
    }
}

int bfs(pi pos) {
    queue<pii> q;
    q.push({pos, 1});
    visited[pos.f][pos.s]++;

    while (!q.empty()) {
        pii curr = q.front();
        q.pop();
        if (curr.f.f == 0 || curr.f.f == N - 1 || curr.f.s == 0 || curr.f.s == M - 1) {
            return curr.s;
        }
        for (int d = 0; d < 4; d++) {
            int nr = curr.f.f + dr[d];
            int nc = curr.f.s + dc[d];
            if (v[nr][nc] >= 2) continue;
            if (visited[nr][nc]) continue;
            if (fire_v[nr][nc] <= curr.s + 1) continue;
            visited[nr][nc]++;
            q.push({{nr, nc}, curr.s + 1});
        }
    }

    return 0;
}

void output() {
    if (!ans) cout << "IMPOSSIBLE";
    else cout << ans;
}

int main() {
    input();
    ans = bfs(P);
    output();
}