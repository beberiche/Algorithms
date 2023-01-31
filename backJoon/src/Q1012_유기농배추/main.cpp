#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
int maps[55][55];
int dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
int N, M, K;
void bfs(int r, int c) {
    queue<pi> q;
    q.push({r, c});
    maps[r][c] = 0;
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;
            if (maps[nr][nc] == 0)
                continue;

            maps[nr][nc] = 0;
            q.push({nr, nc});
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    while (T--) {
        cin >> N >> M >> K;
        int r, c;
        for (int i = 0; i < K; i++) {
            cin >> r >> c;
            maps[r][c] = 1;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 1) {
                    bfs(i, j);
                    ans++;
                }
            }
        }
        cout << ans << "\n";
    }
    return 0;
}