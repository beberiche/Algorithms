#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
int N, E;
struct node {
    int next;
    int dist;
};

struct compare {
    bool operator()(node &n1, node &n2) {
        return n1.dist > n2.dist;
    }
};

vector<node> v[804];
int n1, n2, ans1, ans2;
const int INF = 200000001;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> E;
    int st, ed, d;
    for (int i = 0; i < E; i++) {
        cin >> st >> ed >> d;
        v[st].push_back({ed, d});
        v[ed].push_back({st, d});
    }
    cin >> n1 >> n2;
}

int dijkstra(int st, int ed) {
    priority_queue<node, vector<node>, compare> pq;
    pq.push({st, 0});
    int dist[N+1];
    fill(dist, dist + N + 1, INF);
    dist[st] = 0;
    while (!pq.empty()) {
        node curr = pq.top();
        pq.pop();
        for (node n: v[curr.next]) {
            if (dist[n.next] > n.dist + curr.dist) {
                dist[n.next] = n.dist + curr.dist;
                pq.push({n.next, dist[n.next]});
            }
        }
    }
    return dist[ed];
}

void solve() {
    ans1 = dijkstra(1, n1) + dijkstra(n1, n2) + dijkstra(n2, N);
    ans2 = dijkstra(1, n2) + dijkstra(n2, n1) + dijkstra(n1, N);
}

void output() {
    cout << (min(ans1, ans2) >= INF || min(ans1, ans2) <= 0 ? -1 : min(ans1, ans2));
}

int main() {
    input();
    solve();
    output();
}