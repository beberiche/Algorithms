#include <iostream>
#include <vector>
#include <queue>
#define f first
#define s second

using namespace std;
const int INF = 987654321;
int N, M, total = INF, visited[104], dist[104], ans;
vector<int> v[104];

void input() {
    cin >> N >> M;
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
}

int go(int idx) {
    fill_n(visited, N+1, 0);
    fill_n(dist, N+1, INF);
    visited[idx]++;
    dist[idx] = 0;
    queue<pair<int, int>> q;
    q.push({idx, 0});
    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();
        for (int n: v[curr.f]) {
            if (visited[n]) continue;
            visited[n]++;
            dist[n] = curr.s+1;
            q.push({n, curr.s + 1});
        }
    }

    int sum = 0;
    for (int i = 1; i <= N; i++) sum += dist[i];
    return sum;
}

void solve() {
    for (int i = 1; i <= N; i++) {
        int ret = go(i);
        if (ret < total) {
            total = ret;
            ans = i;
        }
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}