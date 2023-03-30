#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, M, maxCnt, cnt;
vector<int> arr[10001],visited;
int arr2[10001];
void input() {
    cin >> N >> M;
    int st, ed;
    for (int i = 0; i < M; i++) {
        cin >> st >> ed;
        arr[ed].push_back(st);
    }
}

void dfs(int idx) {
    cnt++;
    visited[idx]++;
    for (auto a: arr[idx]) {
        if(!visited[a]) {
            dfs(a);
        }
    }
}

void solve() {
    for (int i = 1; i <= N; i++) {
        cnt = 0;
        visited= vector<int>(N+1, 0);
        dfs(i);
        arr2[i]= cnt;
        maxCnt = max(cnt, maxCnt);
    }
    for (int i = 1; i <= N; i++) {
        if (arr2[i] == maxCnt) cout << i << " ";
    }
}

int main() {
    input();
    solve();
}