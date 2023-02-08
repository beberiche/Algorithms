#include <iostream>
#include <tuple>
#include <vector>
using namespace std;

typedef tuple<int, int, int> tp; // 부모, 본인, depth
const int MAX = 5e5 + 5;
int N, M;
tp a[MAX];
vector<int> v;
vector<int> d[MAX];
bool visited[MAX];
tp tmpB, tmpS;

void output() { cout << get<1>(tmpB) << '\n'; }

void LCA(int n1, int n2) {
    // 더 층이 높은 애 찾기
    tmpB = a[n1];
    tmpS = a[n2];
    if (get<2>(a[n1]) < get<2>(a[n2])) {
        tmpB = a[n2];
        tmpS = a[n1];
    }

    while (get<2>(tmpB) != get<2>(tmpS)) {
        tmpB = a[get<0>(tmpB)];
    }

    while (get<1>(tmpB) != get<1>(tmpS)) {
        tmpB = a[get<0>(tmpB)];
        tmpS = a[get<0>(tmpS)];
    }

    output();
}

void input() {
    cin >> N;
    int n1, n2;
    for (int i = 1; i < N; i++) {
        cin >> n1 >> n2;
        d[n1].push_back(n2);
        d[n2].push_back(n1);
        // a[1] = make_tuple(0, 1, 1);
        // if (get<1>(a[p]) != 0) {
        //     a[c] = make_tuple(p, c, get<2>(a[p]) + 1);
        // } else if (get<1>(a[c]) != 0) {
        //     a[p] = make_tuple(c, p, get<2>(a[c]) + 1);
        // }
    }
}

void dfs(int p, int depth) {
    visited[p] = true;

    for (int n : d[p]) {
        if (visited[n])
            continue;
        a[n] = make_tuple(p, n, depth + 1);
        dfs(n, depth + 1);
    }
}

void solve() {
    cin >> M;
    int n1, n2;
    for (int i = 0; i < M; i++) {
        cin >> n1 >> n2;
        LCA(n1, n2);
    }
}

int main() {

    input();
    a[1] = make_tuple(0, 1, 1);
    dfs(1, 1);
    solve();

    return 0;
}