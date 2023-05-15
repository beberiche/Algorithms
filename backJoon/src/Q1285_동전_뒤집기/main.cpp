#include <iostream>
#include <vector>
using namespace std;
int N, a[21], ans = 401;
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    string s;
    for (int i = 1; i <= N; i++) {
        cin >> s;
        for (int j = 0; j < s.size(); j++) {
            if (s[j] == 'T') a[i] += (1 << j);
        }
    }
}

void solve(int d) {
    if (d > N) {
        int t = 0;
        for (int i = 1; i <= (1 << (N - 1)); i *= 2) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) if (a[j] & i) cnt++;
            t += min(cnt, N - cnt);
        }
        ans = min(ans, t);
        return;
    }

    solve(d + 1);
    a[d] = ~a[d];
    solve(d + 1);
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(1);
    output();
}