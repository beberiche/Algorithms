#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
const int MAX = 16, INF = 987654321;
int N, a[MAX][5];
vector<int> v, vv;
map<int, vector<vector<int>>> m;
int ans = INF;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    for (int i = 0; i < 4; i++) {
        cin >> num;
        v.push_back(num);
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> a[i][j];
        }
    }
}

void solve() {
    for (int i = 1; i < (1 << N); i++) {
        int m0 = 0, m1 = 0, m2 = 0, m3 = 0, m4 = 0;
        vv.clear();
        for (int j = 0; j < N; j++) {
            if ((i & (1 << j)) > 0) {
                m0 += a[j][0];
                m1 += a[j][1];
                m2 += a[j][2];
                m3 += a[j][3];
                m4 += a[j][4];
                vv.push_back(j + 1);
            }
        }
        if (m0 >= v[0] && m1 >= v[1] && m2 >= v[2] && m3 >= v[3] && ans >= m4) {
            ans = m4;
            m[ans].push_back(vector<int>(vv));
        }
    }
}

void output() {
    if (ans == INF) {
        cout << -1;
    } else {
        cout << ans << "\n";
        sort(m[ans].begin(), m[ans].end());
        for (auto n: m[ans][0]) {
            cout << n << " ";
        }
    }
}

int main() {
    input();
    solve();
    output();
}