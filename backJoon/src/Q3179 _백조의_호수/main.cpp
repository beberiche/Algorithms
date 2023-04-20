//
// Created by 김종현 on 2023/04/18.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int R, C, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1}, ans;
char a[1503][1503];
vector<pair<int, int>> pos;
vector<vector<int>> v, v2;
bool check;
queue<pair<int, int>> water1, water2, swan1, swan2;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> R >> C;
    string tmp;
    v = vector<vector<int>>(R, vector<int>(C, 0));
    v2 = vector<vector<int>>(R, vector<int>(C, 0));
    for (int i = 0; i < R; i++) {
        cin >> tmp;
        for (int j = 0; j < C; j++) {
            a[i][j] = tmp[j];
            if (a[i][j] == 'L') {
                pos.push_back({i, j});
                water1.push({i,j});
                v[i][j]++;
            } else if(a[i][j] == '.') {
                water1.push({i,j});
                v[i][j]++;
            }
        }
    }
    swan1.push({pos[0].first, pos[0].second});
    v2[pos[0].first][pos[0].second]++;
}

void go_sea() {
    while (!water1.empty()) {
        pair<int, int> curr = water1.front();
        water1.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (v[nr][nc]) continue;
            v[nr][nc]++;
            if (a[nr][nc] == 'X') {
                a[nr][nc] = '.';
                water2.push({nr, nc});
            } else {
                water1.push({nr, nc});
            }
        }
    }
}

void go_swan() {
    while (!swan1.empty()) {
        pair<int, int> curr = swan1.front();
        swan1.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (v2[nr][nc]) continue;
            v2[nr][nc]++;
            if (a[nr][nc] == 'X') {
                swan2.push({nr, nc});
            } else if (a[nr][nc] == '.') {
                swan1.push({nr, nc});
            } else {
                check = true;
                return;
            }
        }
    }
}

void Qclear(queue<pair<int,int>> &q) {
    queue<pair<int, int>> a;
    swap(q,a);
}

void solve() {
    while (true) {
        go_swan();
        if (check) return;
        go_sea();
        swan1 = swan2;
        water1 = water2;
        Qclear(swan2);
        Qclear(water2);
        ans++;
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}