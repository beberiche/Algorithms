//
// Created by 김종현 on 2023/03/01.
//
#include <queue>
#include <vector>
#include <cstring>
#include <iostream>

#define MAX 100
#define INF 105
using namespace std;

typedef pair<int, int> pi;
typedef pair<int, pi> pii;

int rLen, cLen, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
int dist[MAX][MAX];
pi S, E, L;

struct cmp {
    bool operator() (const pii &a, const pii &b) {
        return a.first < b.first;
    }
};

int dijkstra(pi st,pi ed, vector<string> &maps) {
    memset(dist, INF, sizeof(dist));
    dist[st.first][st.second] = 0;
    priority_queue<pii, vector<pii>, cmp> pq;
    pq.push({0, st});
    while (!pq.empty()) {
        int currRow = pq.top().second.first;
        int currCol = pq.top().second.second;
        int currDist = pq.top().first;
        pq.pop();

        if (currDist > dist[currRow][currCol])
            continue;

        for (int d = 0; d < 4; d++) {
            int nr = currRow + dr[d];
            int nc = currCol + dc[d];
            if (nr < 0 || nc < 0 || nr >= rLen || nc >= cLen)
                continue;
            if (maps[nr][nc] == 'X')
                continue;

            if (dist[nr][nc] > dist[currRow][currCol] + 1) {
                dist[nr][nc] = dist[currRow][currCol] + 1;
                pq.push({dist[nr][nc], {nr, nc}});
            }
        }
    }
    return dist[ed.first][ed.second];
}

int solution(vector<string> maps) {
    rLen = maps.size();
    cLen = maps[0].size();
    for (int i = 0; i < rLen; i++) {
        for (int j = 0; j < cLen; j++) {
            if (maps[i][j] == 'S')
                S = {i, j};
            else if (maps[i][j] == 'E')
                E = {i, j};
            else if (maps[i][j] == 'L')
                L = {i, j};
        }
    }

    int dist1 = dijkstra(S, L,maps);
    int dist2 = dijkstra(L,E, maps);
    return dist1 >= INF || dist2 >= INF ? -1 : dist1 + dist2;
}

int main() {
    cout << solution({"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
}