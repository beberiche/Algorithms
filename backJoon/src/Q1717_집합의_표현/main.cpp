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

void output(string ans) { cout << ans << "\n"; }

void unionParent(int x, int y, bool b) {
    int fx = findSet(x);
    int fy = findSet(y);
    if (fx == fy && b)
        output("YES");
    else if (fx != fy && b)
        output("NO");
    else
        p[findSet(fy)] = findSet(fx);
}

void input() {
    cin >> N >> M;
    for (int i = 1; i <= N; i++)
        p[i] = i;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    for (int i = 0; i < M; i++) {
        cin >> n1 >> n2 >> n3;
        unionParent(n2, n3, n1);
    }
    return 0;
}