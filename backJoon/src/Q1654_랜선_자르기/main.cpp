#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
long long K, N, l=1, r, ans;
vector<int> v;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    cin >> K >> N;
    long long num;
    for (int i = 0; i < K; i++) {
        cin >> num;
        v.push_back(num);
        r = max(num, r);
    }
}

bool check(int mid) {
    int cnt = 0;
    for (int i = 0; i < K; i++) {
        cnt += v[i] / mid;
        if (cnt >= N) break;
    }
    return cnt >= N;
}

void solve() {
    while (l <= r) {
        long long mid = (l + r) >> 1;
        if (check(mid)) {
            l = mid + 1;
            ans = max(mid, ans);
        } else {
            r = mid - 1;
        }
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