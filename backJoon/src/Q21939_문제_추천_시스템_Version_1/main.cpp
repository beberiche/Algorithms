//
// Created by 김종현 on 2023/04/10.
//
#include <iostream>
#include <set>
using namespace std;
typedef pair<int, int> pii;
set<pii> s;
int arr[100000 + 1];

void input() {
    int N, P, L;
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> P >> L;
        s.insert({L, P});
        arr[P] = L;
    }
}

void output(int X) {
    if (X == -1) cout << (*s.begin()).second << "\n";
    else cout << (*prev(s.end())).second << "\n";
}

void solve() {
    int M, P, L;
    cin >> M;
    string str;
    for (int i = 0; i < M; i++) {
        cin >> str;
        if (str == "add") {
            cin >> P >> L;
            s.insert({L, P});
            arr[P] = L;
        } else if (str == "solved") {
            cin >> P;
            s.erase({arr[P], P});
            arr[P] = 0;
        } else {
            cin >> P;
            output(P);
        }
    }
}

int main() {
    ios::sync_with_stdio(0), cin.tie(nullptr), cout.tie(nullptr);
    input();
    solve();
}