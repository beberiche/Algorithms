//
// Created by 김종현 on 2023/07/16.
//
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<long long> v;
long long N, a, b, c, ret;

void input() {
    cin >> N;
    long long num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    ret = 10987654321;
}

void solve() {
    for (int i = 0; i < N - 2; i++) {
        int L = i + 1;
        int R = N - 1;
        while (L < R) {
            long long mid = v[i] + v[L] + v[R];
            if (abs(mid) < ret) {
                ret = abs(mid);
                a = v[i];
                b = v[L];
                c = v[R];
            } else if (mid < 0) L++;
            else R--;
        }
    }
}

void output() {
    cout << a << " " << b << " " << c;
}

int main() {
    input();
    solve();
    output();
}