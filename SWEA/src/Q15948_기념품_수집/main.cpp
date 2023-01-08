#include <bits/stdc++.h>
using namespace std;
const int dr[4] = {-1, 0, 1, 0};
const int dc[4] = {0, 1, 0, -1};
char arr[20][20];
int R, C;
vector<char> split(string s) {
    vector<char> ret;
    for (int i = 0; i < s.size(); i++) {
        ret.push_back(s[i]);
    }
    return ret;
}

int bfs() {
    queue<tuple<int, int, string>> q;
    string str;
    str = arr[0][0];
    q.push({0, 0, str});
    int ans = 1;
    while (q.size() != 0) {
        auto curr = q.front();
        q.pop();
        string ns = get<2>(curr);

        for (int d = 0; d < 4; d++) {
            int nr = get<0>(curr) + dr[d];
            int nc = get<1>(curr) + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                continue;

            if (ns.find(arr[nr][nc]) != string::npos) {
                ans = max(ans, (int)ns.size());
                continue;
            }
            q.push({nr, nc, ns + arr[nr][nc]});
        }
    }
    return ans;
}

int main() {
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> R >> C;
        memset(arr, 0, sizeof(arr));
        for (int i = 0; i < R; i++) {
            string tmp;
            cin >> tmp;
            vector<char> sp = split(tmp);
            for (int j = 0; j < C; j++) {
                arr[i][j] = sp[j];
            }
        }

        cout << "#" << t << " " << bfs() << "\n";
    }
    return 0;
}