#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
int N, arr[1000005];
vector<int> res;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
    }
}

void solve() {
    res.push_back(arr[1]);
    for (int i = 2; i <= N; i++) {
        if (res.back() < arr[i])
            res.push_back(arr[i]);
        else
            res[lower_bound(res.begin(), res.end(), arr[i]) - res.begin()] =
                arr[i];
    }
}

void output() { cout << res.size(); }

int main() {
    input();
    solve();
    output();
    return 0;
}