//
// Created by 김종현 on 2023/05/08.
//
#include <iostream>
#include <queue>
#include <vector>

using namespace std;
char arr[31][31][31];
vector<vector<vector<int>>> visited;
int L, R, C;
pair<int, pair<int, int>> st, ed;
int di[6] = {-1, 0, 1, 0, 0, 0}, dj[6] = {0, 1, 0, -1, 0, 0}, dk[6] = {0, 0, 0, 0, -1, 1};

void input() {
    cin >> L >> R >> C;
    for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
            cin >> arr[i][j];
            for (int k = 0; k < C; k++) {
                if (arr[i][j][k] == 'S') st = {i, {j, k}};
                else if (arr[i][j][k] == 'E') ed = {i, {j, k}};
            }
        }
    }
}

void solve() {
    queue<pair<int, pair<int, int>>> q;
    visited = vector<vector<vector<int>>>(L, vector<vector<int>>(R, vector<int>(C, 0)));
    q.push(st);
    visited[st.first][st.second.first][st.second.second]++;

    while (!q.empty()) {
        pair<int, pair<int, int>> curr = q.front();
        q.pop();
        if (curr.first == ed.first && curr.second.first == ed.second.first && curr.second.second == ed.second.second) {
            printf("Escaped in %d minute(s).\n", visited[curr.first][curr.second.first][curr.second.second] - 1);
            return;
        }
        for (int d = 0; d < 6; d++) {
            int ni = curr.first + di[d];
            int nj = curr.second.first + dj[d];
            int nk = curr.second.second + dk[d];
            if (ni < 0 || nj < 0 || nk < 0 || ni >= L || nj >= R || nk >= C) continue;
            if (visited[ni][nj][nk]) continue;
            if (arr[ni][nj][nk] == '#') continue;
            visited[ni][nj][nk] = visited[curr.first][curr.second.first][curr.second.second] + 1;
            q.push({ni, {nj, nk}});
        }
    }

    printf("Trapped!\n");
}

int main() {
    ios::sync_with_stdio(0),cin.tie(0),cout.tie(0);
    while (true) {
        input();
        if (L == 0 && R == 0 && C == 0) break;
        solve();
    }
}