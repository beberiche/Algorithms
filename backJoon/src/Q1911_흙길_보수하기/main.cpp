#include <iostream>
#include <vector>
#include <algorithm>

#define f first
#define s second
using namespace std;
int N, L, ans;
vector<pair<int, int>> v;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> L;
    int st, ed;
    for (int i = 0; i < N; i++) {
        cin >> st >> ed;
        v.push_back({st, ed});
    }

    sort(v.begin(), v.end());
}

void solve() {
    int ed = 0;
    for (int i = 0; i < N; i++) {
        if (v[i].s <= ed) continue;
        int ret, len;
        if (ed < v[i].f) {
            len = v[i].s - v[i].f;
            ret = len / L;
            if (len % L != 0) ret++;
            ed = v[i].f + (ret * L);
        } else {
            len = v[i].s - ed;
            ret = len / L;
            if (len % L != 0) ret++;
            ed = ed + (ret * L);
        }
        ans += ret;
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}