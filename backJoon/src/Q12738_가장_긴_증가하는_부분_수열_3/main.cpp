//
// Created by 김종현 on 2023/04/23.
//
#include <iostream>
#include <vector>
using namespace std;
int N;
vector<int> v;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    cin >> num;
    v.push_back(num);
    for (int i = 1; i < N; i++) {
        cin >> num;
        if (v.back() < num) {
            v.push_back(num);
            continue;
        }
        int l = 0;
        int r = v.size() - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (v[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        v[r] = num;
    }
}

void output() {
    cout << v.size() << "\n";
}

int main() {
    input();
    output();
}