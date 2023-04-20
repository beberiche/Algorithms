//
// Created by 김종현 on 2023/04/09.
//
#include <iostream>
#include <queue>

using namespace std;
const int MAX = 500000;
int N, K;
int visited[2][MAX + 1];

void input() {
    cin >> N >> K;
}

int BFS() {
    if (N == K) return 0;
    queue<int> q;
    int cnt = 1;
    int mK = K;
    visited[0][N] = 1;
    q.push(N);
    while (!q.empty()) {
        mK += cnt;
        if(mK > MAX) break;
        if (visited[cnt % 2][mK]) return cnt;
        int currSize = q.size();
        while (currSize--) {
            int curr = q.front();
            q.pop();
            for (int next: {curr + 1, curr - 1, curr * 2}) {
                if (next < 0 || next > MAX || visited[cnt % 2][next]) continue;
                visited[cnt % 2][next] = visited[(cnt + 1) % 2][curr] + 1;
                if (next == mK) return cnt;
                q.push(next);
            }
        }
        cnt++;
    }
    return -1;
}

void output() {
    cout << BFS();
}

int main() {
    input();
    output();
}