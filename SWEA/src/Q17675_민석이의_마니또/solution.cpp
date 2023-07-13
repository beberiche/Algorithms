#include <iostream>
#include <queue>
#include <algorithm>
#include <string.h>
#define f first
#define s second
using namespace std;
int N, M, visited[404], ans;
vector<vector<pair<int, int>>> v;

void input() {
    cin >> N >> M;
    v = vector<vector<pair<int, int>>>(N + 1);
    int n1, n2, d;
    for (int i = 0; i < M; i++) {
        cin >> n1 >> n2 >> d;
        v[n1].push_back({d, n2});
    }
}

void bfs(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, start});

    while (!pq.empty()) {
        pair<int, int> curr = pq.top();
        pq.pop();
        for (auto n: v[curr.s]) {
            if (visited[n.s]) continue;
            visited[n.s]++;
            if (start == n.s) ans = min(ans, (curr.f + n.f));
            pq.push({(curr.f + n.f), n.s});
        }
    }
}

void solve() {
    ans = 987654321;
    for (int i = 1; i <= N; i++) {
        memset(visited, 0, sizeof(visited));
        bfs(i);
    }
}

void output(int t) {
    cout << "#" << t << " " << (ans == 987654321 ? -1 : ans) << "\n";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        input();
        solve();
        output(t);
    }
}