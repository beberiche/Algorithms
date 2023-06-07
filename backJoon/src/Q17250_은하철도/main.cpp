#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector<int> a, p, sum;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M;
    a.push_back(0), p.push_back(0), sum.push_back(0);
    int num;
    for (int i = 1; i <= N; i++) {
        cin >> num;
        a.push_back(num);
        p.push_back(i);
        sum.push_back(a[i]);
    }
}

int getParent(int n) {
    if (p[n] == n) return n;
    return p[n] = getParent(p[n]);
}

int unionParent(int a, int b) {
    int pa = getParent(a);
    int pb = getParent(b);
    if (pa < pb) {
        sum[pa] += sum[pb];
        p[pb] = pa;
        return sum[pa];
    } else if (pa > pb) {
        sum[pb] += sum[pa];
        p[pa] = pb;
        return sum[pb];
    }
    return sum[pa];
}

void go() {
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        cout << unionParent(a, b) << "\n";
    }
}

int main() {
    input();
    go();
}