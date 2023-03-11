//
// Created by 김종현 on 2023/03/12.
//
#include <iostream>
#include <cstring>
#include <vector>

using namespace std;
char arr[5][5];
int dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1}, cnt, dist, ans;
vector<int> v;
bool visited[5][5];

void dfs(int r, int c) {
    visited[r][c] = false;
    arr[r][c] == 'S' && cnt++, dist++;
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d], nc = c + dc[d];
        if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || !visited[nr][nc]) continue;
        dfs(nr, nc);
    }
}

void comb(int idx) {
    if (v.size() >= 7) {
        memset(visited, false, sizeof(visited));
        cnt = 0;
        dist = 0;
        for (int i = 0; i < 7; i++) {
            int r = v[i] / 5;
            int c = v[i] % 5;
            visited[r][c] = true;
        }
        dfs(v[0]/5, v[0]%5);
        if (cnt >= 4 && dist >= 7) ans++;
        return;
    }

    for (int i = idx; i < 25; i++) {
        v.push_back(i);
        comb(i + 1);
        v.pop_back();
    }
}

void input() {
    for (int i = 0; i < 5; i++) {
        cin >> arr[i];
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    comb(0);
    output();
}