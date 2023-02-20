#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;
int N, ans;
vector<int> v;
map<int, int> m;

void input() {
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
}

void solve() {
    for (int i = 0; i < N; i++) {
        int curr_num = v[i];
        int l = 0;
        int r = N - 1;
        if (m[curr_num]) {
            ans++;
            continue;
        }
        while (l < r) {
            int sum = v[l] + v[r];
            if (sum == curr_num) {
                if (i == l)
                    l++;
                else if (i == r)
                    r--;
                else {
                    m.insert({sum, 1});
                    ans++;
                    break;
                }
            } else if (sum < curr_num)
                l++;
            else
                r--;
        }
    }
}

void output() { cout << ans; }

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    solve();
    output();
    return 0;
}