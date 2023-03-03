//
// Created by 김종현 on 2023/03/03.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
int T,N, M;
vector<int> A,B;
void input(){
    A.clear();
    B.clear();
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
    ll sum = 0;
    for(int i=0; i<M; i++) {
        sum += A.end() - upper_bound(A.begin(), A.end(), B[i]);
    }
    cout << sum << "\n";
}

int main() {
    cin >> T;
    while(T--) {
        input();
        solve();
    }
}