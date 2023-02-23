//
// Created by 김종현 on 2023/02/21.
//
#include <iostream>
#include <queue>
#include <vector>
using namespace std;
typedef pair<int, int> pi;
const int LEN = 1e3 + 4;
const int dr[4] = {-1, 0, 1, 0};
const int dc[4] = {0, -1, 0, 1};
int N, M, arr[LEN][LEN];
bool visited[LEN][LEN];

void input() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
        }
    }
}

void bfs(int i, int j) {
    queue<pi> q;
    q.push({i, j});
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];

            if (nr < 0) nr = N - 1;
            else if (nc < 0) nc = M - 1;
            else if (nr >= N) nr = 0;
            else if (nc >= M) nc = 0;

            if (visited[nr][nc]) continue;
            else if (arr[nr][nc] == 1) continue;
            visited[nr][nc] = true;
            q.push({nr, nc});
        }
    }
}

void output(int ans) {
    cout << ans;
}

int solve() {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arr[i][j] == 0 && !visited[i][j]) {
                visited[i][j] = true;
                bfs(i, j);
                cnt++;
            }
        }
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    output(solve());
    return 0;
}