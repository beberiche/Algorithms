//
// Created by 김종현 on 2023/04/23.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N;
vector<pair<int, int>> v;
vector<int> vv;

bool cmp(pair<int, int> a, pair<int, int> b) {
    return a.first < b.first;
}

void input() {
    cin >> N;
    int a, b;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        v.push_back({a, b});
    }
    sort(v.begin(), v.end(), cmp);
}

void solve() {
    vv.push_back(v[0].second);
    for (int i = 1; i < N; i++) {
        if (v[i].second > vv.back()) {
            vv.push_back(v[i].second);
            continue;
        }
        int idx = lower_bound(vv.begin(), vv.end(), v[i].second) - vv.begin();
        vv[idx] = v[i].second;
    }
}

void output() {
    cout << v.size() - vv.size();
}

int main() {
    input();
    solve();
    output();
}