//
// Created by 김종현 on 2023/03/15.
//
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
typedef pair<int, int> pi;
int N, M, arr[104][104], cnt, c_cnt, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
void input() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) c_cnt++;
        }
    }
}

void solve() {
    bool visited[N][M];
    memset(visited, false, sizeof (visited));
    queue<pi> q;
    q.push({0, 0});
    visited[0][0] = true;
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if(arr[nr][nc] == 0 || arr[nc][nc] >= 3) {
                visited[nr][nc] = true;
            } else if(arr[nr][nc] >=1) {
                arr[nr][nc]++;
                if(arr[nr][nc] == 3) {
                    arr[nr][nc] = 0;
                    c_cnt--;
                    visited[nr][nc] = true;
                }
                continue;
            }
            q.push({nr,nc});
        }
    }

    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            if(arr[i][j]==2) arr[i][j] = 1;
        }
    }
}

void output() {
    cout << cnt;
}

int main() {
    input();
    while (c_cnt != 0) {
        cnt++;
        solve();
    }
    output();
}