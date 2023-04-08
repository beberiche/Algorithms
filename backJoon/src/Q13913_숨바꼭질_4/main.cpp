//
// Created by 김종현 on 2023/04/06.
//
#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int N, M, v[100001], p[100001];

void input() {
    cin >> N >> M;
}

void bfs() {
    queue<int> q;
    q.push(N);

    v[N] = 1;
    p[N] = N;
    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        if (curr == M) break;
        for (int n: {curr + 1, curr - 1, curr * 2}) {
            if (n > 100000 || n < 0) continue;
            if (v[n]) continue;
            v[n] = v[curr] + 1;
            p[n] = curr;
            q.push(n);
        }
    }
}

void output() {
    cout << v[M] - 1 << "\n";
    vector<int> ans;
    while (true) {
        ans.push_back(M);
        if (M == p[M]) break;
        M = p[M];
    }
    for (int i = ans.size() - 1; i >= 0; i--) {
        cout << ans[i] << " ";
    };
}

int main() {
    input();
    bfs();
    output();
}