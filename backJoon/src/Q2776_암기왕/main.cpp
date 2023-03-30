//
// Created by 김종현 on 2023/03/30.
//
#include <iostream>
#include <unordered_map>

using namespace std;
int T, N, M;
unordered_map<int, int> mp;

void solve() {
    cin >> T;
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(NULL);
    for (int t = 0; t < T; t++) {
        cin >> N;
        mp.clear();
        int num;
        for (int n = 0; n < N; n++) {
            cin >> num;
            mp.insert({num, 1});
        }

        cin >> M;
        for(int m=0; m<M; m++) {
            cin >> num;
            cout << (mp[num] ? "1\n" : "0\n");
        }
    }
}

int main() {
    solve();
}