#include <bits/stdc++.h>
using namespace std;
const int dr[4] = {-1, 0, 1, 0};
const int dc[4] = {0, 1, 0, -1};
char arr[24][24];
bool check[26];
int ans;
int R, C;

void dfs(int r, int c, int dep) {
    ans = max(ans, dep);
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nc < 0 || nr >= R || nc >= C)
            continue;

        if (check[arr[nr][nc] - 'A'])
            continue;

        check[arr[nr][nc] - 'A'] = true;
        dfs(nr, nc, dep + 1);
        check[arr[nr][nc] - 'A'] = false;
    }
}

int main(void) {
    int T;
    scanf("%d", &T);
    for (int t = 1; t <= T; t++) {
        scanf("%d %d", &R, &C);
        for (int i = 0; i < R; i++) {
            scanf("%s", arr[i]);
        }
        check[arr[0][0] - 'A'] = true;
        ans = 0;
        dfs(0, 0, 1);
        check[arr[0][0] - 'A'] = false;
        printf("#%d %d\n", t, ans);
    }
    return 0;
}