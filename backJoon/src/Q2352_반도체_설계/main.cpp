//
// Created by 김종현 on 2023/02/20.
//
#include <iostream>
#include <vector>

using namespace std;
int N, num;
vector<int> v;

int lowerBound(int curr) {
    int l = 0;
    int r = v.size();
    while (l < r) v[(l + r) / 2] >= curr ? r = (l + r) / 2 : l = (l + r) / 2 + 1;
    return r;
}

void input() {
    cin >> N >> num;
    v.push_back(num);
    for (int i = 1; i < N; i++) {
        cin >> num;
        if (v.back() < num) v.push_back(num);
        else v[lowerBound(num)] = num;
    }
}

void output() {
    cout << v.size();
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    output();
}