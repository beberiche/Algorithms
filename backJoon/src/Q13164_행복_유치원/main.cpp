#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, K;
vector<int> v, v2;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> K;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
}

void solve() {

    for (int i = 0; i < N - 1; i++) {
        v2.push_back(v[i + 1] - v[i]);
    }

    sort(v2.begin(), v2.end(), greater<int>());
}

void output() {
    int ans = 0;
    for (int i = K - 1; i < v2.size(); i++) {
        ans += v2[i];
    }
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}