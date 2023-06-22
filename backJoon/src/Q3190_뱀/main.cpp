#include <iostream>
#include <vector>
#include <queue>
#define f first
#define s second
using namespace std;
vector<pair<int, int>> v;
queue<pair<int,int>> t;
int a[104][104], visited[104][104];
int dr[] = {0, 1, 0, -1},dc[] = {1, 0, -1, 0};
int currDir = 0, ans = 0;
int N, K;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> K;
    int r, c;
    for (int i = 0; i < K; i++) {
        cin >> r >> c;
        a[r - 1][c - 1] = 1;
    }

    cin >> K;
    int _t;
    char ch;
    for (int i = 0; i < K; i++) {
        cin >> _t >> ch;
        if (ch == 'D') {
            t.push({_t, 1});
        } else {
            t.push({_t, 3});
        }
    }
    v.push_back({0, 0});
    visited[0][0] = 1;
}

void solve() {
    while (true) {
        ans++;
        auto curr = v.front();
        int nr = curr.f + dr[currDir];
        int nc = curr.s + dc[currDir];

        // 벽에 부딪히거나 자기몸과 부딪히는 경우
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) break;

        // 사과 확인
        if (!a[nr][nc]) {
            visited[v.back().f][v.back().s] = 0;
            v.pop_back();
        } else a[nr][nc] = 0;

        visited[nr][nc] = 1;
        v.insert(v.begin(), {nr,nc});
        if(ans == t.front().f) {
            currDir = (currDir+t.front().s)%4;
            t.pop();
        }
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