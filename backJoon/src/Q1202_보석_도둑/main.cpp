//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int N, K;
vector<int> bags;
vector<pair<int, int>> jewels;
long ans;

void input() {
    cin >> N >> K;
    jewels = vector<pair<int, int>>(N);
    bags = vector<int>(K);
    for (int i = 0; i < N; i++) cin >> jewels[i].first >> jewels[i].second;
    for (int i = 0; i < K; i++) cin >> bags[i];
    sort(jewels.begin(), jewels.end());
    sort(bags.begin(), bags.end());
}

void solve() {
    int idx = 0;
    priority_queue<int> pq;
    for (int i = 0; i < K; i++) {
        while (idx < N && jewels[idx].first <= bags[i]) pq.push(jewels[idx++].second);
        if (pq.size()) ans += pq.top(), pq.pop();
    }
}

void output() {
    cout << ans;
}

int main() {
    ios::sync_with_stdio(0), cin.tie(NULL), cout.tie(NULL);
    input();
    solve();
    output();
}