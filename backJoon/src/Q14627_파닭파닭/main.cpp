//
// Created by 김종현 on 2023/03/31.
//
#include <iostream>
#include <vector>

using namespace std;
int S, C, l = 1, r = 1e9;
long long sum,pa;
vector<int> v;
void input() {
    cin >> S >> C;
    int num;
    for (int i = 0; i < S; i++) {
        cin >> num;
        sum += num;
        v.push_back(num);
    }
}

bool check(int mid) {
    int cnt = 0;
    for (int i = 0; i < S; i++) {
        cnt += v[i] / mid;
    }
    return cnt >= C;
}

void solve() {
    while (l <= r) {
        int mid = (l + r) / 2;
        if (check(mid)) {
            pa = mid;
            l = mid+1;
        } else {
            r = mid-1;
        }
    }
}

void output() {
    cout << sum-pa*C;
}

int main() {
    input();
    solve();
    output();
}
