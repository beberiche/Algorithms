#include <bits/stdc++.h>
using namespace std;
int n;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, -1, 0, 1};
vector<pair<int, int>> nMap[505][505];
bool visited[505][505];
int arr[505][505];
int ans = 0;

void DFS(int r, int c, int d) {
    if (d > ans)
        d = ans;
    visited[r][c] = true;
    for (auto pos : nMap[r][c]) {
        if (visited[pos.first][pos.second])
            continue;
        DFS(pos.first, pos.second, d + 1);
    }
    visited[r][c] = false;
};

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int d = 0; d < 4; d++) {
                int nr = i + dr[d];
                int nc = j + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (arr[i][j] < arr[nr][nc]) {
                    pair<int, int> p = {nr, nc};
                    nMap[i][j].push_back(p);
                }
            }
        }
    }

    DFS(0, 0, 0);
    cout << ans;
    return 0;
}