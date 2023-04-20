#include <iostream>
#include <vector>

using namespace std;
long long N, M, ans;
vector<int> rides;

void input() {
    cin >> N >> M;
    int num;
    for (int i = 0; i < M; i++) {
        cin >> num;
        rides.push_back(num);
    }
}

void solve() {
    // 예외 1: 인원보다 놀이기구 수가 많은 경우
    if (N <= M) {
        ans = N;
        return;
    }
    long long l = 0;
    long long r = 6e10;
    long long mid, temp, ret, total = N - M;
    while (l <= r) {
        mid = (l + r) / 2;
        temp = 0;
        for (int i = 0; i < M; i++) {
            temp += mid / rides[i];
            if (temp > total) break;
        }
        if (temp >= total) {
            ret = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    for (int i = 0; i < M; i++) total -= ((ret - 1) / rides[i]);
    for (int i = 0; i < M; i++) {
        if (ret % rides[i] == 0) total--;
        if (total == 0) {
            ans = i + 1;
            return;
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