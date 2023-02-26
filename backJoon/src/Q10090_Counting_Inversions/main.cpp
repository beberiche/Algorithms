//
// Created by 김종현 on 2023/02/26.
//
#include <iostream>
#include <vector>

using namespace std;
int N;
long long ans;
vector<int> v;

void solve(int st, int ed, int* tmp) {
    if(st>=ed) return;

    int mid = (st + ed) / 2;
    solve(st, mid, tmp);
    solve(mid + 1, ed, tmp);

    int l = st;
    int r = mid + 1;
    int idx = st;

    while (l <= mid && r <= ed) {
        if (v[l] < v[r]) {
            tmp[idx++] = v[l++];
        } else {
            tmp[idx++] = v[r++];
            ans += mid + 1 - l;
        }
    }

    while (l <= mid) tmp[idx++] = v[l++];
    while (r <= ed) tmp[idx++] = v[r++];

    for (int i = st; i <= ed; i++) {
        v[i] = tmp[i];
    }
}

void input() {
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    int tmp[N];
    solve(0, N - 1, tmp);
    output();
}
