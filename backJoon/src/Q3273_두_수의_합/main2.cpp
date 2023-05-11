//
// Created by 김종현 on 2023/05/11.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, cmp, ans;
vector<int> v;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    cin >> cmp;
}

void solve() {
    int l = 0;
    int r = N - 1;
    while (l < r) {
        int num = v[l] + v[r];
        if (num == cmp) l++, r--, ans++;
        else if (num < cmp) l++;
        else r--;
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

