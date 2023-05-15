#include <iostream>
#include <vector>

using namespace std;
int N, K, a[51], ans;
//int t

void input() {
    string s;
    for (int i = 0; i < N; i++) {
        cin >> s;
        for (int j = 0; j < s.size(); j++) {
            int num = (1 << (int) (s[j] - 'a'));
            a[i] |= a[i] & num ? 0 : num;
            // t |= t & num ? 0 : num;
        }
    }
}

void solve(int d, int idx, int curr) {
    if (d >= K) {
        int cnt = 0;
        for (int i = 0; i < N; i++) if ((curr & a[i]) == a[i]) cnt++;
        ans = max(ans, cnt);
        return;
    }
    for (int i = idx; i < 26; i++) {
        int num = 1 << i;
        if (curr & num) continue;
        //if (!(t & num)) continue;
        solve(d + 1, i + 1, curr | num);
    }
}

void output() {
    cout << ans;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> K;
    if (K < 5) {
        cout << 0;
        return 0;
    }
    input();
    solve(5, 0, 532741);
    output();
}