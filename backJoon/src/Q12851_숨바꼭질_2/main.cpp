//
// Created by 김종현 on 2023/04/05.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int N, K;
vector<int> visited;

pair<int, int> BFS() {
    queue<int> q;
    q.push(N);
    bool check = false;
    int cnt = 0;
    int min = 987654321;
    visited[N] = 0;
    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        if (check && min > visited[curr]) break;
        if (curr == K) {
            check = true;
            min = visited[curr];
            cnt++;
        }
        int mr = curr - 1;
        int pr = curr + 1;
        int gr = curr * 2;
        if (mr >= 0 && visited[mr] >= visited[curr] + 1) {
            visited[mr] = visited[curr] + 1;
            q.push(mr);
        }
        if (pr <= 100000 && visited[pr] >= visited[curr] + 1) {
            visited[pr] = visited[curr] + 1;
            q.push(pr);
        }
        if (gr > 0 && gr <= 100000 && visited[gr] >= visited[curr] + 1) {
            visited[gr] = visited[curr] + 1;
            q.push(gr);
        }
    }

    return {min, cnt};
}

void input() {
    cin >> N >> K;
    visited = vector<int>(200000, 100005);
}

int main() {
    input();
    pair<int, int> ans = BFS();
    cout << ans.first << "\n" << ans.second;
}