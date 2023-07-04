#include <iostream>
#include <vector>
#include <queue>
#include <string.h>

#define f first
#define s second
using namespace std;
int T, K;
vector<char> v[1004];
queue<pair<int, int>> q;

// T개만큼의 백터 생성
// 각 톱니의 2번, 7번을 얻어내는 함수 비교
// 현재 톱니를 시작점에 대하여 서로 일치하면 상대편 톱니 현재 방향과 다르게 회전
//  현재 톱니 7번과 이전의 톱니 2번 비교
//  현재 톱니 2번과 다음 톱니 7번 비교
//  방문처리도 필요할 듯
// 마지막에 현재 0번값 확인
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> T;
    string str;
    for (int i = 1; i <= T; i++) {
        cin >> str;
        for (int j = 0; j < str.size(); j++) {
            v[i].push_back(str[j]);
        }
    }
}

void go(int gear, int dir) {
    if (dir == 1) {
        int ed = v[gear][7];
        for (int i = 7; i > 0; i--) {
            v[gear][i] = v[gear][i - 1];
        }
        v[gear][0] = ed;
    } else {
        int st = v[gear][0];
        for (int i = 0; i < 7; i++) {
            v[gear][i] = v[gear][i + 1];
        }
        v[gear][7] = st;
    }
}

void solve() {
    cin >> K;
    int idx, dir;
    for (int i = 0; i < K; i++) {
        cin >> idx >> dir;
        int visited[T+1];
        memset(visited, 0, sizeof(visited));
        q.push({idx, dir});
        while (!q.empty()) {
            pair<int, int> curr = q.front();
            q.pop();
            if (visited[curr.f]) continue;
            visited[curr.f] = 1;
            char idx2 = v[curr.f][2];
            char idx6 = v[curr.f][6];
            go(curr.f, curr.s);
            int prev_g = curr.f - 1;
            int next_g = curr.f + 1;
            if (prev_g >= 1 && idx6 != v[prev_g][2]) q.push({prev_g, curr.s * -1});
            if (next_g <= T && idx2 != v[next_g][6]) q.push({next_g, curr.s * -1});
        }
    }
}

void output() {
    int ans = 0;
    for (int i = 1; i <= T; i++) {
        if (v[i][0] == '1') ans++;
    }
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}