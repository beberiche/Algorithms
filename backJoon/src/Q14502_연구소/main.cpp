//
// Created by 김종현 on 2023/03/15.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;
typedef pair<int, int> pi;
int N, M, zero_cnt,answer = 65, arr[8][8], copy_arr[8][8], dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
vector<int> v, num;
vector<pi> vir;

void input() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 2) vir.push_back({i, j});
            else if(arr[i][j] == 0) zero_cnt++;
        }
    }
    for (int i = 0; i < N * M; i++) {
        num.push_back(i);
    }
}

void bfs() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            copy_arr[i][j] = arr[i][j];
        }
    }
    for (int n: v) {
        copy_arr[n / M][n % M] = 1;
    }
    queue<pi> q;
    for (auto v: vir) {
        q.push(v);
    }
    int cnt = 0;
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (copy_arr[nr][nc] != 0) continue;
            copy_arr[nr][nc] = 2;
            q.push({nr, nc});
            cnt++;
        }
    }
    answer = min(answer, cnt);
}

void solve(int idx) {
    if (v.size() == 3) {
        bfs();
        return;
    }
    for (int i = idx; i < num.size(); i++) {
        int pos = arr[i / M][i % M];
        if (pos == 1 && pos == 2) continue;
        v.push_back(i);
        solve(i + 1);
        v.pop_back();
    }
}

void output() {
    cout << zero_cnt-answer-3;
}

int main() {
    input();
    solve(0);
    output();
}