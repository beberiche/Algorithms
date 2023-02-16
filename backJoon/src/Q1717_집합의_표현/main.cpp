#include <iostream>
using namespace std;
const int N_MAX = 1e6 + 4;
int N, M;
int p[N_MAX], n1, n2, n3;

int findSet(int n) {
    if (p[n] == n)
        return n;
    return p[n] = findSet(p[n]);
}

string cmpParent(int x, int y) {
    int fx = findSet(x);
    int fy = findSet(y);
    return fx == fy ? "YES" : "NO";
}

void unionParent(int x, int y) {
    int fx = findSet(x);
    int fy = findSet(y);
    fx > fy ? p[x] = y : p[y] = x;
}

void output() { cout << cmpParent(n2, n3) << "\n"; }

void solve() { n1 ? output() : unionParent(n2, n3); }

void input() {
    cin >> N >> M;

    for (int i = 1; i <= N; i++) {
        p[i] = i;
    }

    for (int i = 0; i < M; i++) {
        cin >> n1 >> n2 >> n3;
        solve();
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    return 0;
}