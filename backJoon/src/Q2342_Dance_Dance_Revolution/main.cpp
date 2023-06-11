#include <iostream>
#include <vector>
#include <string.h>
#define f first
#define s second
using namespace std;
vector<int> v;
const int MAX = 1e6 + 4;
int ans, dp[5][5][MAX];

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    int num;
    while (true) {
        cin >> num;
        if (num == 0) break;
        v.push_back(num);
    }
}

int check(int currf, int nextf) {
    if (currf == nextf) return 1;
    else if (currf == 0) return 2;
    else if (abs(currf - nextf) != 2) return 3;
    else return 4;
}

int go(pair<int, int> pi, int cnt) {
    if (cnt >= (int)v.size()) return 0;
    if (dp[pi.f][pi.s][cnt] != -1) return dp[pi.f][pi.s][cnt];
    int l = go({v[cnt], pi.s}, cnt + 1) + check(pi.f, v[cnt]);
    int r = go({pi.f, v[cnt]}, cnt + 1) + check(pi.s, v[cnt]);

    return dp[pi.f][pi.s][cnt] = min(l, r);
}

void solve() {
    memset(dp, -1, sizeof(dp));
    ans = go({0, 0}, 0);
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}