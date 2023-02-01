#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
int N, M, K, maps[104][104], dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
bool visited[104][104];
vector<int> v;
int dfs(int r, int c) {
    visited[r][c] = true;
    int ret = 1;
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M)
            continue;
        if (visited[nr][nc])
            continue;
        if (maps[nr][nc] > 0)
            continue;

        ret += dfs(nr, nc);
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> K;

    int s1, s2, e1, e2;
    for (int i = 0; i < K; i++) {
        cin >> s1 >> s2 >> e1 >> e2;
        for (int r = s2; r < e2; r++) {
            for (int c = s1; c < e1; c++) {
                maps[r][c]++;
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (maps[i][j] == 0 && !visited[i][j]) {
                ans++;
                v.push_back(dfs(i, j));
            }
        }
    }
    sort(v.begin(), v.end());
    cout << ans << "\n";
    for (int n : v) {
        cout << n << " ";
    }
    return 0;
}