#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, arr[21][21], ans = 2004;
vector<int> v1, v2;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0),cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
        }
    }
}

int comb(vector<int> &v) {
    int ret= 0;
    for (int j = 0; j < v.size(); j++) {
        for (int k = j + 1; k < v.size(); k++) {
            ret += arr[v[j]][v[k]] + arr[v[k]][v[j]];
        }
    }
    return ret;
}

void solve() {
    for (int i = (1<<(N/2))-1; i <= ((1 << N) - 1); i++) {
        v1.clear(), v2.clear();
        for (int j = 0; j < N; j++) {
            if (i & (1 << j)) v1.push_back(j);
            else v2.push_back(j);
        }
        if (v1.size() == N / 2) {
            int ret = abs(comb(v1) - comb(v2));
            ans = min(ans, ret);
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