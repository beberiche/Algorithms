#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;
typedef tuple<int, int, int> tp;
int arr[105][105], N, M, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
bool visited[105][105];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < M; j++) {
            arr[i][j] = str[j] - '0';
        }
    }

    queue<tp> q;
    q.push(make_tuple(0, 0, 1));
    visited[0][0] = true;

    while (!q.empty()) {
        tp curr = q.front();
        q.pop();
        if (get<0>(curr) == N - 1 && get<1>(curr) == M - 1) {
            cout << get<2>(curr);
            return 0;
        }

        for (int d = 0; d < 4; d++) {
            int nr = get<0>(curr) + dr[d];
            int nc = get<1>(curr) + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;
            if (visited[nr][nc])
                continue;
            if (arr[nr][nc] == 0)
                continue;

            visited[nr][nc] = true;
            q.push(make_tuple(nr, nc, get<2>(curr) + 1));
        }
    }

    return 0;
}