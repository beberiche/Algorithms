//
// Created by 김종현 on 2023/04/13.
//
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int N, ans;
vector<pair<int, int>> v;
priority_queue<int, vector<int>, greater<int>> pq;

void input() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> N;
    int d, p;
    for (int i = 0; i < N; i++) {
        cin >> p >> d;
        v.push_back({d, p});
    }
    sort(v.begin(), v.end());
}

void solve() {
    for (int i = 0; i < N; i++) {
        pq.push(v[i].second);
        if (pq.size() > v[i].first) pq.pop();
    }
    while (!pq.empty()) {
        ans += pq.top(); pq.pop();
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