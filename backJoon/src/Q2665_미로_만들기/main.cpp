#include <iostream>
#include <queue>
#include <string>
using namespace std;
const int MAX = 50 + 5;
struct Node {
    int r, c, block;
};
int dr[4] = {-1, 0, 1, 0}, dc[4] = {0, 1, 0, -1};
int N;
int arr[MAX][MAX];
int dist[MAX][MAX];

struct cmp {
    bool operator()(Node n1, Node n2) { return n1.block > n2.block; }
};

void input() {
    cin >> N;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < N; j++) {
            arr[i][j] = str[j] - '0';
            dist[i][j] = MAX * MAX + 5;
        }
    }
}

void output(int ans) { cout << ans; }

void bfs() {
    priority_queue<Node, vector<Node>, cmp> pq;
    pq.push({0, 0, 0});
    while (!pq.empty()) {
        Node curr = pq.top();
        pq.pop();
        if (curr.r == N - 1 && curr.c == N - 1) {
            output(curr.block);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = curr.r + dr[d];
            int nc = curr.c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if (arr[nr][nc] == 0 && dist[nr][nc] > curr.block + 1) {
                dist[nr][nc] = curr.block + 1;
                pq.push({nr, nc, curr.block + 1});
            } else if (arr[nr][nc] == 1 && dist[nr][nc] > curr.block) {
                dist[nr][nc] = curr.block;
                pq.push({nr, nc, curr.block});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    bfs();
    return 0;
}