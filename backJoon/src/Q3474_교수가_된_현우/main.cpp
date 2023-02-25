//
// Created by 김종현 on 2023/02/25.
//
#include <iostream>
using namespace std;
int N, curr_num;

int solve() {
    int num = 0;
    for(int i=5; i<=curr_num; i*=5) num += curr_num/i;
    return num;
}

void output(int ans) {
    cout << ans << "\n";
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> curr_num;
        int ans = solve();
        output(ans);
    }
}