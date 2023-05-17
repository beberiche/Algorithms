#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, K, a[104], visited[104];
vector<int> v;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> K;
    for (int i = 0; i < K; i++) {
        cin >> a[i];
    }
}

void solve() {
    int ans = 0;
    for (int i = 0; i < K; i++) {
        if (visited[a[i]]) continue;
        if(v.size()==N) {
            int last_idx = 0, pos;
            for (int _a: v) {
                int here_pick = 987654321;
                for (int j = i + 1; j < K; j++) {
                    if (_a == a[j]) {
                        here_pick = j;
                        break;
                    }
                }
                if (last_idx < here_pick) {
                    last_idx = here_pick;
                    pos = _a;
                }
            }
            visited[pos]--;
            v.erase(find(v.begin(), v.end(), pos));
            ans++;
        }
        v.push_back(a[i]);
        visited[a[i]]++;
    }
    cout << ans;
}

int main() {
    input();
    solve();
}