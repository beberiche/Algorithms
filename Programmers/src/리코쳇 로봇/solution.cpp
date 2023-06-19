#include <vector>
#include <queue>
#define f first
#define s second
using namespace std;
queue<pair<pair<int,int>, int>> q;
int dr[4] = {-1,0,1,0};
int dc[4] = {0,-1,0,1};
pair<int,int> goal;
int visited[104][104];

int solution(vector<string> board) {
    int answer = 0;
    for(int i=0; i<board.size(); i++) {
        for(int j=0; j<board[i].size(); j++) {
            if(board[i][j]=='R') {
                q.push({{i,j},0});
            } else if(board[i][j] == 'G') {
                goal = {i,j};
            }
        }
    }

    while(!q.empty()) {
        pair<pair<int,int>,int> curr = q.front();
        q.pop();
        if(visited[curr.f.f][curr.f.s]) continue;
        visited[curr.f.f][curr.f.s]++;

        if(curr.f.f == goal.f && curr.f.s == goal.s) return curr.s;

        for(int d=0;d<4; d++) {
            int nr = curr.f.f;
            int nc = curr.f.s;

            while(true) {
                nr += dr[d];
                nc += dc[d];

                if(nr < 0 || nc < 0 || nr >= board.size() || nc >= board[0].size() || board[nr][nc] == 'D') {
                    nr -= dr[d];
                    nc -= dc[d];
                    q.push({{nr,nc},curr.s+1});
                    break;
                }
            }
        }
    }
    return -1;
}