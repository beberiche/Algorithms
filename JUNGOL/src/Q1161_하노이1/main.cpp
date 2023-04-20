//
// Created by 김종현 on 2023/04/14.
//
#include <iostream>
#include <vector>
using namespace std;
int N;
vector<int> v;

void input() {
    cin >> N;
    for (int i = 0; i <= N; i++) {
        v.push_back(i);
    }
}

void solve(int from, int to, int via, int cnt) {
    if(cnt == 0) return;

    solve(from, via, to, cnt-1);
    cout << cnt << " : " << from << " -> " << to << "\n";
    solve(via, to, from, cnt-1);
}

int main() {
    input();
    solve(1, 3, 2,N);
}