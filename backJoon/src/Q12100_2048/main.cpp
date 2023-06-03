#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, ans;
vector<vector<int>> v;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    v.resize(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> v[i][j];
        }
    }
}

int getMax(vector<vector<int>> &curr) {
    int ret = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            ret = max(ret, curr[i][j]);
        }
    }
    return ret;
}

void move(vector<vector<int>> &curr) {
    vector<vector<int>> tmp(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        int cIdx = 0;
        bool check = false;
        for (int j = 0; j < N; j++) {
            if (!curr[i][j]) continue;
            if (check && curr[i][j] == tmp[i][cIdx-1]) {
                tmp[i][cIdx-1] *= 2;
                check = false;
            } else {
                tmp[i][cIdx++] = curr[i][j];
                check = true;
            }
        }
        for (; cIdx < N; cIdx++) tmp[i][cIdx] = 0;
    }
    copy(tmp.begin(), tmp.end(), curr.begin());
}

void rotate(vector<vector<int>> &curr) {
    vector<vector<int>> tmp(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            tmp[i][j] = curr[N - j - 1][i];
        }
    }
    copy(tmp.begin(), tmp.end(), curr.begin());
}

void solve(vector<vector<int>> &curr, int cnt) {
    if (cnt >= 5) {
        ans = max(ans, getMax(curr));
        return;
    }

    for (int i = 0; i < 4; i++) {
        vector<vector<int>> tmp(curr);
        move(tmp);
        solve(tmp, cnt + 1);
        rotate(curr);
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(v, 0);
    output();
}