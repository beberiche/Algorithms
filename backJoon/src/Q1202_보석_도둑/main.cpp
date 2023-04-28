//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int N, K;
vector<int> b;
vector<pair<int, int>> j;
long ans;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N >> K;
    int n1,n2;
    for(int i=0; i<N; i++) {
        cin >> n1 >> n2;
        j.push_back({n1,n2});
    }
    for(int i=0; i<K; i++) {
        cin >> n1;
        b.push_back(n1);
    }
    sort(j.begin(), j.end());
    sort(b.begin(), b.end());

}

void solve() {
    int idx = 0;
    priority_queue<int> pq;
    for(int i=0; i<K; i++) {
        while(idx<N && j[idx].first<=b[i]) pq.push(j[idx++].second);
        if(!pq.empty()) {
            ans += pq.top();
            pq.pop();
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