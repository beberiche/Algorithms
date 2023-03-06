//
// Created by 김종현 on 2023/03/06.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;
typedef pair<int, int> pi;
int m, n, sumDist;
const int M_MAX = 200004;
vector<pi> v[M_MAX];

struct cmp {
    bool operator()(pi p1, pi p2) {
        return p1.second > p2.second;
    }
};

void prim() {
    priority_queue<pi, vector<pi>, cmp> pq;
    bool visited[m];
    visited[0] = true;
    for (int i = 0; i < v[0].size(); i++) pq.push(v[0][i]);

    while (!pq.empty()) {
        pi curr = pq.top();
        pq.pop();
        if (visited[curr.first]) continue;
        visited[curr.first] = true;
        sumDist -= curr.second;
        for (auto next: v[curr.first]) {
            if (visited[next.first]) continue;
            pq.push(next);
        }
    }
}

void output() {
    cout << sumDist << "\n";
}

void input() {
    while (1) {
        cin >> m >> n;
        if (m == 0 && n == 0) break;
        for (int i = 0; i < m; i++) v[i].clear();
        sumDist = 0;
        int s, e, dist;
        for (int i = 0; i < n; i++) {
            cin >> s >> e >> dist;
            v[s].push_back({e, dist});
            v[e].push_back({s, dist});
            sumDist += dist;
        }
        prim();
        output();
    }
}


int main() {
    input();
}