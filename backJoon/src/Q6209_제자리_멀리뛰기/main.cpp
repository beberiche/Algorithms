//
// Created by 김종현 on 2023/05/10.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> v;
int D, N, M, ans;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> D >> N >> M;
    v.push_back(0);
    v.push_back(D);
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
}

bool go(int mid) {
    int cnt = 0;
    int prev = 0;
    for (int i = 1; i < v.size(); i++) {
        if (v[i] - v[prev] < mid) cnt++;
        else prev = i;
    }
    return cnt <= M;
}

void solve() {
    int l = 0;
    int r = D;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (go(mid)) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
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