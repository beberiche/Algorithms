//
// Created by 김종현 on 2023/03/03.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, M;
vector<int> A,B;
void input() {
    cin >> N >> M;
    int num;
    for(int i=0; i<N; i++) {
        cin >> num;
        A.push_back(num);
    }

    for(int i=0; i<M; i++) {
        cin >> num;
        B.push_back(num);
    }
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
}

void solve() {
    int cnt = 0;
    for(int i=0; i<N; i++) {
        int curr_idx = lower_bound(B.begin(), B.end(), A[i])-B.begin();
        if(A[i] != B[curr_idx]) cnt++;
    }
    for(int i=0; i<M; i++) {
        int curr_idx = lower_bound(A.begin(), A.end(), B[i])-A.begin();
        if(B[i] != A[curr_idx]) cnt++;
    }
    cout << cnt;
}

int main() {
    input();
    solve();
}