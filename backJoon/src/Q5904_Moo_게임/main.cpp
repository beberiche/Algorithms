//
// Created by 김종현 on 2023/03/13.
//
#include <iostream>
using namespace std;

void solve(int N, int next_idx, int curr_len) {
    int next_len = curr_len * 2 + next_idx + 3;
    if (N <= 3) {
        cout << (N - 1 == 0 ? 'm' : 'o');
        return;
    }
    if (next_len < N) {
        solve(N, next_idx + 1, next_len);
    } else {
        if (N > curr_len && N <= curr_len + next_idx + 3) {
            cout << (N - curr_len - 1 == 0 ? 'm' : 'o');
            return;
        } else {
            solve(N - (curr_len + next_idx + 3), 1, 3);
        }
    }
}

int main() {
    int num;
    cin >> num;
    solve(num, 1, 3);
}