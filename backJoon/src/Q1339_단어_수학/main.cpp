//
// Created by 김종현 on 2023/02/22.
//
#include <iostream>
#include <algorithm>
using namespace std;
const int arr_LEN = 10;
const int A_LEN = 26;
int N, A[A_LEN];
string arr[arr_LEN];

bool cmp(int n1, int n2) {
    return n1 > n2;
}

void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < N; i++) {
        int idx = 1;
        for (int j = arr[i].length() - 1; j >= 0; j--) {
            A[arr[i][j] - 'A'] += idx;
            idx *= 10;
        };
    }

    sort(A, A + A_LEN, cmp);
}

int solve() {
    int sum = 0;
    int cnt = 9;
    for (int i = 0; i < 10; i++) {
        sum += A[i] * cnt--;
    }
    return sum;
}

void output(int ans) {
    cout << ans;
}

int main() {
    input();
    int ans = solve();
    output(ans);
}