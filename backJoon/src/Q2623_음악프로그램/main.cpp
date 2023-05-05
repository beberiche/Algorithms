//
// Created by 김종현 on 2023/05/05.
//
#include <iostream>
#include <vector>
#include <queue>

#define MAX 1004
using namespace std;
int N, M;
vector<int> v[MAX];
int d[MAX];
int res[MAX];

void input() {
    cin >> N >> M;
    int cnt, prev, next;
    for (int i = 0; i < M; i++) {
        cin >> cnt >> prev;
        for (int j = 1; j < cnt; j++) {
            cin >> next;
            v[prev].push_back(next);
            d[next]++;
            prev = next;
        }
    }
}

void solve() {
    queue<int> q;
    for (int i = 1; i <= N; i++) {
        if (d[i] == 0) q.push(i);
    }

    for (int i = 1; i <= N; i++) {
        if (q.empty()) {
            cout << 0;
            return;
        }
        int curr = q.front();
        q.pop();

        res[i] = curr;
        for(auto next : v[curr]) {
            if(--d[next] == 0) q.push(next);
        }
    }

    for(int i=1; i<=N; i++) {
        cout << res[i] << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    input();
    solve();
}