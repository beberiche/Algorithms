//
// Created by 김종현 on 2023/02/26.
//
#include <iostream>
#include <vector>

using namespace std;
int N, K, cnt;
vector<int> v;

void printK() {
    for (int i = 0; i < N; i++) {
        cout << v[i] << " ";
    }
}

void merge(int st, int ed, int mid) {
    int buff[N];
    int l = st;
    int r = mid + 1;
    int idx = st;
    while (l <= mid && r <= ed) {
        if (v[l] < v[r]) {
            buff[idx++] = v[l++];
        } else {
            buff[idx++] = v[r++];
        }
    }

    while (l <= mid) {
        buff[idx++] = v[l++];
    }

    while (r <= ed) {
        buff[idx++] = v[r++];
    }

    for (int i = st; i <= ed; i++) {
        v[i] = buff[i];
        if (++cnt == K) printK();
    }
}

void merge_sort(int st, int ed) {
    if (st >= ed) return;
    int mid = (st + ed) / 2;
    merge_sort(st, mid);
    merge_sort(mid + 1, ed);
    merge(st, ed, mid);
}

void solve() {
    cin >> N >> K;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    merge_sort(0, N - 1);
    if (cnt < K) cout << -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();
}