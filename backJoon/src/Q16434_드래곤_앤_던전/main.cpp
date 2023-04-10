//
// Created by 김종현 on 2023/03/29.
//
#include <iostream>
#define f first
#define s second
using namespace std;
typedef pair<int, int> pi;
typedef pair<int, pi> pii;
typedef long long ll;
int N, A;
ll ans;
pii stage[123456 + 1];

bool go(ll hp) {
    ll currA = A;
    ll currHp = hp;
    for (int i = 0; i < N; i++) {
        if (stage[i].f == 1) {
            ll cnt = stage[i].s.s % currA == 0 ? stage[i].s.s / currA : stage[i].s.s / currA + 1;
            currHp -= (cnt - 1) * stage[i].s.f;
            if (currHp <= 0) return false;
        } else {
            currA += stage[i].s.f;
            currHp += stage[i].s.s;
            if (currHp > hp) currHp = hp;
        }
    }
    return true;
}

void solve() {
    ll l = 1;
    ll r = 1e6*1e6*N;
    while (l <= r) {
        ll mid = (l + r) / 2;
        if (go(mid)) {
            r = mid - 1;
            ans = mid;
        } else {
            l = mid + 1;
        }
    }
}

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> A;
    int t, a, h;
    for (int i = 0; i < N; i++) {
        cin >> t >> a >> h;
        stage[i] = {t, {a, h}};
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