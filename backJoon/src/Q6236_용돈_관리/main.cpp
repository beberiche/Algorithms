//
// Created by 김종현 on 2023/03/02.
//
#include <iostream>
#include <vector>

using namespace std;
int N, M, v_sum, v_min = 1e9 + 4, ans;
vector<int> v;

void input() {
    cin >> N >> M;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v_sum += num;
        v_min = min(v_min, num);
        v.push_back(num);
    }
}

bool check(int mid) {
    int cnt = 0;
    int tmp = mid;
    for (int i = 0; i < N; i++) {
        if (cnt > M) return false;
        if (tmp - v[i] < 0) {
            cnt++;
            tmp = mid;
            i--;
            continue;
        }
        tmp -= v[i];
    }
    if (tmp > 0) cnt++;
    return M >= cnt;
}

void solve() {
    int l = v_min;
    int r = v_sum;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (check(mid)) {
            ans = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
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