
#include <iostream>

using namespace std;
int N, M, B, a[504][504];
int min_n=257, max_n=-1;
long long h, t = 500*500*2*256+2;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N >> M >> B;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
            min_n = min(min_n, a[i][j]);
            max_n = max(max_n, a[i][j]);
        }
    }
}

pair<int, int> check(int mid) {
    int cnt = B;
    int time = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (mid == a[i][j]) continue;
            else if (mid > a[i][j]) {
                cnt -= mid - a[i][j];
                time += (mid - a[i][j]);
            } else {
                cnt += a[i][j] - mid;
                time += 2 * (a[i][j] - mid);
            }
        }
    }
    return {cnt, time};
}

void solve() {
    for (int i = min_n; i <= max_n; i++) {
        pair<int, int> curr = check(i);
        if (curr.first >= 0 && curr.second <= t) {
            h = i;
            t = curr.second;
        }
    }
}

void output() {
    cout << t << " " << h;
}

int main() {
    input();
    solve();
    output();
}