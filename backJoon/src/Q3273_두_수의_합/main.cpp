//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, cmp_num, ans;
vector<int> v;
void input() {
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num, v.push_back(num);
    }
    cin >> cmp_num;
}

void solve() {
    sort(v.begin(),v.end());
    int l=0, r=v.size()-1;
    int sum;
    while(l<r) {
        sum = v[l] + v[r];
        if(sum == cmp_num) l++, r--, ans++;
        else if (sum < cmp_num) l++;
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