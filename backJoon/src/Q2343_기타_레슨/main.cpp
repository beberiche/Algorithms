//
// Created by 김종현 on 2023/03/02.
//
#include <iostream>
#include <vector>

using namespace std;
typedef long long ll;
int N, M;
vector<ll> v;
ll ans = 1e18, sum, curr_max;

void input() {
    cin >> N >> M;
    ll num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        sum += num;
        v.push_back(num);
    }
}

bool check(ll mid) {
    int cnt = 0;
    ll sum = 0;
    curr_max = 0;
    for (int i = 0; i < N; i++) {
        sum += v[i];
        if (sum < mid) continue;
        if (sum > mid) {
            sum -= v[i];
            i--;
        }
        curr_max = max(curr_max, sum);
        sum = 0;
        cnt++;
        if(cnt > M) return false;
    }
    if(sum > 0) cnt++;
    return M >= cnt;
}

void solve() {
    int l = v.front();
    int r = sum;
    while (l <= r) {
        ll mid = (l + r) / 2;
        if (check(mid)) {
            ans = min(ans, curr_max);
            r = mid-1;
        } else {
            l = mid+1;
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