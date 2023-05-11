//
// Created by 김종현 on 2023/05/11.
//
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
int N, st, ed;
vector<int> v;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
}

void solve() {
    unordered_map<int, int> m;
    long long ans = 0;
    while (ed < N) {
        if (!m[v[ed]]) {
            m[v[ed++]]++;
        } else {
            ans += ed - st;
            m.erase(v[st++]);
        };
    }
    ans += (long long) (ed - st) * (ed - st + 1) / 2;
    cout << ans;
}

int main() {
    input();
    solve();
}