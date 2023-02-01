#include <algorithm>
#include <cstring>
#include <iostream>
#include <queue>
using namespace std;

typedef pair<int, int> pi;
int N, maps[104][104], copyMaps[104][104], dr[4] = {-1, 0, 1, 0},
                                           dc[4] = {0, -1, 0, 1};
bool visited[104][104];

void init(int val) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            copyMaps[i][j] = maps[i][j] - val;
        }
    }

    memset(visited, false, sizeof(visited));
}

void bfs(int r, int c) {
    queue<pi> q;
    visited[r][c] = true;
    q.push({r, c});

    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if (visited[nr][nc])
                continue;
            if (copyMaps[nr][nc] < 0)
                continue;

            visited[nr][nc] = true;
            q.push({nr, nc});
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    int maxH = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> maps[i][j];
            maxH = max(maps[i][j], maxH);
        }
    }

    int ans = 0;
    for (int i = 1; i <= maxH; i++) {
        init(i);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMaps[i][j] >= 0 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        ans = max(ans, cnt);
    }
    cout << ans;
    return 0;
}