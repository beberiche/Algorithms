#include <bits/stdc++.h>
using namespace std;
const int dr[4] = {-1, 0, 1, 0};
const int dc[4] = {0, 1, 0, -1};
char arr[24][24];
int ans = 1;
int R, C;

void dfs(int r, int c, string str) {
    ans = max(ans, (int)str.length());
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C)
            continue;

        if (str.find(arr[nr][nc]) == string::npos)
            dfs(nr, nc, str + arr[nr][nc]);
    }
}

int main(void) {
    int T;
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> R >> C;
        for (int i = 0; i < R; i++) {
            cin >> arr[i];
        }
        ans = 1;
        string tmp;
        tmp = arr[0][0];
        dfs(0, 0, tmp);
        cout << "#" << t << " " << ans << "\n";
    }
    return 0;
}