#include <iostream>
#include <string.h>

#define f first
#define s second
using namespace std;
const int MAX = 5000;
int N, M, Q, a[MAX][MAX], visited[MAX], ans;
pair<int, int> m[MAX];

void input() {
    cin >> N >> M >> Q;
    pair<int, int> ret;
    for (int i = 1; i <= N; i++) {
        ret = {0, 0};
        for (int j = 1; j <= M; j++) {
            cin >> a[i][j];
            if (ret.s <= a[i][j]) ret = {j, a[i][j]};
        }
        m[i] = ret;
    }
}

int go() {
    int ret = 0;
    memset(visited, 0, sizeof(visited));
    for (int i = 1; i <= N; i++) {
        if (visited[m[i].f]) continue;
        visited[m[i].f]++;
        ret++;
    }
    return ret;
}

void solve() {
    int r, c, val;
    int ret = go();
    ans = 0;
    for (int i = 1; i <= Q; i++) {
        cin >> r >> c >> val;
        if (m[r].s < val) {
            m[r] = {c, val};
            ret = go();
        }
        ans += ret;
    }
}

void output(int t) {
    cout << "#" << t << " " << ans << "\n";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        input();
        solve();
        output(t);
    }
}