//
// Created by 김종현 on 2023/03/21.
//
#include <iostream>
using namespace std;

int N,M,st,ed,val;
int arr[100000+4], sum[100000+4];
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for(int i=1; i<=N; i++) cin >> arr[i];
    while(M--) {
        cin >> st >> ed >> val;
        sum[st] += val;
        sum[ed + 1] -= val;
    }
}

void solve() {
    int acc = 0;
    for(int i=1; i<=N; i++) {
        acc += sum[i];
        cout << arr[i]+acc << " ";
    }
}
int main() {
    input();
    solve();
}