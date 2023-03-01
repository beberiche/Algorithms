#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;
typedef pair<int, int> pi;
typedef pair<pi, int> pii;
int rLen, cLen, dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
bool visited[100][100];
pi S, E, L;

void output(int ans) { cout << ans; }

int bfs(pi st, pi ed, vector<string> maps) {
    queue<pii> q;
    q.push({st, 0});
    visited[st.first][st.second] = true;
    while (!q.empty()) {
        pii curr = q.front();
        q.pop();
        if (curr.first.first == ed.first && curr.first.second == ed.second)
            return curr.second;

        for (int d = 0; d < 4; d++) {
            int nr = curr.first.first + dr[d];
            int nc = curr.first.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= rLen || nc >= cLen)
                continue;
            if (visited[nr][nc])
                continue;
            if (maps[nr][nc] == 'X')
                continue;

            visited[nr][nc] = true;
            q.push({{nr, nc}, curr.second+1});
        }
    }
    return -1;
}

void input(vector<string> maps) {
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
}

void visited_reset() {
    for(int i=0; i<rLen; i++) {
        for(int j=0; j<cLen; j++) {
            visited[i][j] = false;
        }
    }
}


int solution(vector<string> maps) {
    input(maps);
    int dist1 = bfs(S, L, maps);
    visited_reset();
    int dist2 = bfs(L, E, maps);
    return dist1 == -1 || dist2 == -1 ? -1 : dist1+dist2;
}

int main() { solution({"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}); }