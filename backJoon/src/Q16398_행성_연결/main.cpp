#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>
using namespace std;
typedef tuple<int, int, int> tp;
const int MAX = 1e4 + 3;
int p[MAX], N;
vector<tp> v;
bool cmp(tp &v1, tp &v2) { return get<2>(v1) < get<2>(v2); }
void input() {
    cin >> N;
    for (int i = 1; i <= N; i++) {
        p[i] = i;
    }

    int arr[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
            if (i < j)
                v.push_back(make_tuple(i, j, arr[i][j]));
        }
    }
    sort(v.begin(), v.end(), cmp);
}

int findSet(int n) {
    if (p[n] == n)
        return n;
    return p[n] = findSet(p[n]);
}

int unionParent(int e1, int e2) {
    e1 = findSet(e1);
    e2 = findSet(e2);
    if (e1 == e2)
        return 0;
    p[findSet(e2)] = findSet(e1);
    return 1;
}

long long kruskal() {
    long long ans = 0;
    int cnt = 0;
    for (int i = 0; i < v.size(); i++) {
        if (unionParent(get<0>(v[i]), get<1>(v[i]))) {
            ans += get<2>(v[i]);
            if (++cnt == N - 1)
                break;
        }
    }
    return ans;
}

void output() { cout << kruskal(); }

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    output();
    return 0;
}