//
// Created by 김종현 on 2023/04/22.
//

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
vector<vector<int>> ans;
vector<int> v;
int K, len;

void input() {
    cin >> K;
    ans = vector<vector<int>>(K, vector<int>());
    len = pow(2, K) - 1;
    int num;
    for (int i = 0; i < len; i++) {
        cin >> num;
        v.push_back(num);
    }
}

void solve(int st, int ed, int d) {
    if (K <= d) return;
    int mid = (st + ed) / 2;
    ans[d].push_back(v[mid]);
    solve(st, mid - 1, d + 1);
    solve(mid + 1, ed, d + 1);
}

void output() {
    for (int i = 0; i < ans.size(); i++) {
        for (auto a: ans[i]) {
            cout << a << " ";
        }
        cout << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    input();
    solve(0, len - 1, 0);
    output();
}
