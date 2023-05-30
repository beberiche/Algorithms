#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define f first
#define s second
using namespace std;
int N, M, a[52][52], visited[52][52];
int dr[4] = {0, -1, 0, 1}, dc[4] = {-1, 0, 1, 0};
int max_r, max_r2, r_cnt = 1;
vector<int> r_sizes;
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> a[i][j];
        }
    }
}

int bfs(int r, int c, int v[][52]) {
    queue<pair<int, int>> q;
    q.push({r, c});
    v[r][c] = r_cnt;
    int ret = 1;
    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();
        for (int b = 0; b < 4; b++) {
            if (a[curr.f][curr.s] & (1 << b)) continue;
            else {
                int nr = curr.f + dr[b];
                int nc = curr.s + dc[b];
                if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if (v[nr][nc]) continue;
                v[nr][nc] = r_cnt;
                q.push({nr, nc});
                ret++;
            }
        }
    }
    return ret;
}


void solve() {
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            // 이 성의 방의 갯수 및 가장 넓은 방의 넓이 구하기.
            if(!visited[i][j]){
                int curr_room_size = bfs(i, j, visited);
                max_r = max(max_r, curr_room_size);
                r_cnt++;
                r_sizes.push_back(curr_room_size);
            }
        }
    }

    // 벽 1개를 없앨경우 얻을수 있는 가장 넓은 구간 구하기.
    for(int i=0; i<M; i++) {
        for(int j=0; j<N; j++) {
            if(i+1<M) {
                int n1 = visited[i+1][j]-1;
                int n2 = visited[i][j]-1;
                if(n1 != n2) max_r2 = max(max_r2, r_sizes[n1]+r_sizes[n2]);
            }
            if(j+1<N) {
                int n1 = visited[i][j+1]-1;
                int n2 = visited[i][j]-1;
                if(n1 != n2) max_r2 = max(max_r2, r_sizes[n1]+r_sizes[n2]);
            }
        }
    }
}

void output() {
    cout << r_cnt -1 << "\n";
    cout << max_r << "\n";
    cout << max_r2 << "\n";
}


int main() {
    input();
    solve();
    output();
}