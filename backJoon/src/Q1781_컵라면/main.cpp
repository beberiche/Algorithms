//
// Created by 김종현 on 2023/04/24.
//
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
priority_queue<int, vector<int>, greater<int>> pq;
int N, ret;
vector<pair<int, int>> v;

bool cmp(pair<int, int> p1, pair<int, int> p2) {
    if (p1.first == p2.first) return p1.second > p2.second;
    return p1.first < p2.first;
}

void input() {
    ios::sync_with_stdio(0), cin.tie(0);
    cin >> N;
    int a, b;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        v.push_back({a, b});
    }
    sort(v.begin(), v.end(), cmp);
}


void solve() {
    for (int i = 0; i < v.size(); i++) {
        pq.push(v[i].second);
        if (pq.size() > v[i].first) pq.pop();
    }
    while (!pq.empty()) {
        ret += pq.top();
        pq.pop();
    }
}

void output() {
    cout << ret;
}

int main() {
    input();
    solve();
    output();
}