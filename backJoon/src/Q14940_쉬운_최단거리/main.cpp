#include <iostream>
#include <queue>

#define f first
#define s second
using namespace std;
const int MAX = 1004;
int N, M;
int a[MAX][MAX], ans[MAX][MAX], dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
pair<int, int> st;
vector<pair<int, int>> v;
queue<pair<int, pair<int, int>>> q;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
            if (a[i][j] == 2) q.push({0, {i, j}});
        }
    }
}

void bfs() {
    while (!q.empty()) {
        auto curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.s.f + dr[d];
            int nc = curr.s.s + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (a[nr][nc] != 1) continue;
            if (ans[nr][nc] == 0) {
                ans[nr][nc] = curr.f + 1;
                q.push({curr.f + 1, {nr, nc}});
            }
        }
    }
}

void output() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cout << (a[i][j] != 1 ? 0 : !ans[i][j] ? -1 : ans[i][j]) << " ";
        }
        cout << "\n";
    }
}

int main() {
    input();
    bfs();
    output();
}