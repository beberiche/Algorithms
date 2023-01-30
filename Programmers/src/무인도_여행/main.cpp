#include <algorithm>
#include <queue>
#include <string>
#include <vector>
using namespace std;
typedef pair<int, int> pi;
char arr[104][104];
bool visited[104][104];
int dr[4] = {-1, 0, 1, 0}, dc[4] = {0, -1, 0, 1};
int rLen, cLen;

int bfs(int i, int j) {
    queue<pi> q;
    int cnt = arr[i][j] - '0';
    q.push(make_pair(i, j));
    visited[i][j] = true;
    while (!q.empty()) {
        pi curr = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = curr.first + dr[d];
            int nc = curr.second + dc[d];
            if (nr < 0 || nc < 0 || nr >= rLen || nc >= cLen)
                continue;
            if (visited[nr][nc])
                continue;
            if (arr[nr][nc] == 'X')
                continue;

            visited[nr][nc] = true;
            cnt += arr[nr][nc] - '0';
            q.push(make_pair(nr, nc));
        }
    }
    return cnt;
}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    for (int i = 0; i < maps.size(); i++) {
        string str = maps[i];
        for (int j = 0; j < str.size(); j++)
            arr[i][j] = str[j];
    };
    rLen = maps.size();
    cLen = maps[0].size();
    for (int i = 0; i < rLen; i++) {
        for (int j = 0; j < cLen; j++) {
            if (arr[i][j] != 'X' && !visited[i][j])
                answer.push_back(bfs(i, j));
        }
    }
    sort(answer.begin(), answer.end());

    if (answer.size() == 0)
        answer.push_back(-1);
    return answer;
}

int main() {
    solution({"X591X", "X1X5X", "X231X", "1XXX1"});
    return 0;
}