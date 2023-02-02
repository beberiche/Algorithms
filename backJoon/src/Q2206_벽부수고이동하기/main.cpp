#include <iostream>
#include <queue>
using namespace std;
int N, M, maps[1004][1004];
bool visited[1004][1004][2];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, -1, 0, 1};

struct Node {
    int r, c, dist;
    bool crush;
};

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < M; j++) {
            maps[i][j] = str[j] - '0';
        }
    }
}

int bfs() {
    queue<Node> q;
    q.push({0, 0, 1, false});
    visited[0][0][0] = true;
    while (!q.empty()) {
        Node curr = q.front();
        q.pop();

        if (curr.r == N - 1 && curr.c == M - 1) {
            return curr.dist;
        }

        for (int d = 0; d < 4; d++) {
            int nr = curr.r + dr[d];
            int nc = curr.c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;

            if (visited[nr][nc][0] && visited[nr][nc][1])
                continue;

            if (maps[nr][nc] == 0) {
                if (!curr.crush && !visited[nr][nc][0]) {
                    visited[nr][nc][0] = true;
                    q.push({nr, nc, curr.dist + 1, curr.crush});
                } else if (curr.crush && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    q.push({nr, nc, curr.dist + 1, curr.crush});
                }
            } else if (maps[nr][nc] == 1) {
                if (!curr.crush) {
                    visited[nr][nc][1] = true;
                    q.push({nr, nc, curr.dist + 1, true});
                }
            }
        }
    }

    return -1;
}

int main() {
    input();
    cout << bfs();
    return 0;
}