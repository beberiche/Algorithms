//
// Created by 김종현 on 2023/03/28.
//
#include <iostream>
#include <vector>
using namespace std;
int N,idx,pIdx,cnt;
vector<int> v[51];
void input() {
    cin >> N;
    int num;
    for(int i=0; i<N; i++) {
        cin >> num;
        if(num == -1) pIdx = i;
        else v[num].push_back(i);
    }
    cin >> idx;
}

int dfs(int currIdx) {
    if(currIdx == idx) return -1;
    if(v[currIdx].empty()) {
        cnt++;
        return 0;
    }
    for(auto c : v[currIdx]) {
        int tmp = dfs(c);
        if(tmp == -1 && v[currIdx].size() == 1) cnt++;
    }
    return 0;
}

void solve() {
    dfs(pIdx);
}

void output() {
    cout << cnt;
}

int main() {
    input();
    solve();
    output();
}