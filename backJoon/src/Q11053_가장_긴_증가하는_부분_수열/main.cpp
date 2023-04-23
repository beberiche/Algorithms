//
// Created by 김종현 on 2023/04/23.
//
#include <iostream>
#include <vector>

using namespace std;
vector<int> v;
int N;

void input() {
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
        auto idx = lower_bound(v.begin(), v.end(), num);
        cout << &idx << " " << *idx << "\n";
        v[idx - v.begin()] = num;

    }
    cout << v.size();
}

int main() {
    input();
}