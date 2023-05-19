#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;
int N;
vector<int> v[10], p, visited;
unordered_map<int, char> m;
const int INF = 987654321;
int ans = INF;
int a, b, sta, stb, sum_a, sum_b;
void input() {
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        p.push_back(num);
    }

    int n;
    for (int i = 0; i < N; i++) {
        cin >> n;
        int node;
        for (int j = 0; j < n; j++) {
            cin >> node;
            v[i].push_back(node - 1);
        }
    }
}

int check(int node, char t) {
    visited[node]++;
    int ret = 1;
    for (auto n: v[node]) {
        if (m[n] != t || visited[n]) continue;
        ret += check(n, t);
    }
    return ret;
}

void solve() {
    for (int i = 1; i < (1 << N) - 1; i++) {
        a = b = 0;
        sta = stb = -1;
        visited = vector<int>(N, 0);
        for (int j = 0; j < N; j++) {
            if (i & (1 << j)) {
                m[j] = 'a', a++;
                sta = j;
            } else {
                m[j] = 'b', b++;
                stb = j;
            }
        }

        if ((check(sta, 'a') + check(stb, 'b')) == N) {
            sum_a = sum_b = 0;
            for (int j = 0; j < N; j++) {
                if (m[j] == 'a') sum_a += p[j];
                else sum_b += p[j];
            }
            ans = min(ans, abs(sum_a - sum_b));
        };
    }
}

void output() {
    cout << (ans == INF ? -1 : ans);
}

int main() {
    input();
    solve();
    output();
}