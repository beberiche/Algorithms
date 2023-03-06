//
// Created by 김종현 on 2023/03/06.
//
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;
typedef pair<int, int> pi;
typedef pair<int, pi> pii;

const int N_MAX = 1e6 + 4;
int N, p[N_MAX], cnt;
priority_queue<pii> pq;
vector<pi> arr[3];
ll result;

int findParent(int n) {
    if (p[n] == n) return n;
    return p[n] = findParent(p[n]);
}

bool setUnion(int n1, int n2) {
    int p1 = findParent(n1);
    int p2 = findParent(n2);
    if (p1 == p2) return false;
    p[p1] = p2;
    cnt++;
    return true;
}

void solve() {
    while (cnt < N - 1) {
        pii curr = pq.top();
        pq.pop();
        if (setUnion(curr.second.first, curr.second.second))
            result += curr.first*-1;
    }
}

void output() {
    cout << result;
}

void input() {
    cin >> N;
    int x, y, z;
    for (int i = 0; i < N; i++) p[i] = i;

    for (int i = 0; i < N; i++) {
        cin >> x >> y >> z;
        arr[0].push_back({x, i});
        arr[1].push_back({y, i});
        arr[2].push_back({z, i});
    };

    sort(arr[0].begin(), arr[0].end());
    sort(arr[1].begin(), arr[1].end());
    sort(arr[2].begin(), arr[2].end());

    for (int i = 0; i < N-1; i++) {
        pq.push({arr[0][i].first - arr[0][i + 1].first, {arr[0][i].second, arr[0][i + 1].second}});
        pq.push({arr[1][i].first - arr[1][i + 1].first, {arr[1][i].second, arr[1][i + 1].second}});
        pq.push({arr[2][i].first - arr[2][i + 1].first, {arr[2][i].second, arr[2][i + 1].second}});
    }
}

int main() {
    input();
    solve();
    output();
}