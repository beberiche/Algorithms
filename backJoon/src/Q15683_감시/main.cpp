//
// Created by 김종현 on 2023/04/03.
//
#include <iostream>
#include <vector>

#define f first
#define s second
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int, int> pii;
int N, M, ans = 987654321;
vvi v;
vector<pii> list;
vi dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};

void input() {
    cin >> N >> M;
    v = vvi(N, vi(M, 0));
    int num = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> num;
            v[i][j] = num;
            if (v[i][j] <= 5 && v[i][j] >= 1) list.push_back({i, j});
        }
    }
}

vvi copyMap() {
    vvi temp = vvi(N, vi(M, 0));
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) temp[i][j] = v[i][j];
    return temp;
}

void copyMapRev(vvi copy) {
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) v[i][j] = copy[i][j];
}

void go(int r, int c, int d) {
    d %= 4;
    int curr_r = r, curr_c = c;
    while (true) {
        int nr = curr_r + dr[d], nc = curr_c + dc[d];
        curr_r = nr, curr_c = nc;
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] == 6) return;
        if (v[nr][nc] > 0) continue;
        v[nr][nc] = -1;
    }
}

int getCount() {
    int temp = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (v[i][j] == 0) temp++;
        }
    }
    return temp;
}

void dfs(int idx) {
    if (idx >= list.size()) {
        ans = min(getCount(), ans);
        return;
    }

    int dir = v[list[idx].f][list[idx].s];
    for (int d = 0; d < 4; d++) {
        vvi copy_v = copyMap();
        if (dir == 1) go(list[idx].f, list[idx].s, d);
        else if (dir == 2) for (int i = 0; i <= 2; i += 2) go(list[idx].f, list[idx].s, d + i);
        else if (dir == 3) for (int i = 0; i < 2; i++) go(list[idx].f, list[idx].s, d + i);
        else if (dir == 4) for (int i = 0; i < 3; i++) go(list[idx].f, list[idx].s, d + i);
        else if (dir == 5) for (int i = 0; i < 4; i++) go(list[idx].f, list[idx].s, d + i);
        dfs(idx + 1);
        copyMapRev(copy_v);
    }
}

void output() {
    cout << ans;
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie();
    input();
    dfs(0);
    output();
}