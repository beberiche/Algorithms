//
// Created by 김종현 on 2023/03/02.
//
#include <iostream>

using namespace std;
typedef long long ll;
ll N, M, arr[300000+4], ans = 1e18;

bool check(ll mid) {
    ll num = 0;
    for (int i = 0; i < M; i++) {
        num += arr[i] / mid;
        if(arr[i] % mid) num++;
    }
    return N >= num;
}

int main() {
    cin >> N >> M;
    ll l = 1, r = 0;
    for (int i = 0; i < M; i++) cin >> arr[i], r = max(arr[i], r);
    while (l <= r) {
        ll mid = (l + r) / 2;
        if (check(mid)) {
            ans = min(ans, mid);
            r = mid-1;
        } else {
            l = mid+1;
        }
    }
    cout << ans;
}