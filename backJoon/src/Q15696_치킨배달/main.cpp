//
// Created by 김종현 on 2023/04/01.
//
#include <iostream>
#include <vector>

#define f first
#define s second
using namespace std;
typedef pair<int, int> pi;
int N, M, ans = 987654321;
vector<vector<int>> v;
vector<pi> vc, vh, temp;

void input() {
    cin >> N >> M;
    v = vector<vector<int>> (N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> v[i][j];
            if (v[i][j] == 2) vc.push_back({i, j});
            else if (v[i][j] == 1) vh.push_back({i, j});
        }
    }
}

void go(int idx) {
    if (temp.size() >= M) {
        int total = 0;
        for (int i = 0; i < vh.size(); i++) {
            int currDist = 987654321;
            for (int j = 0; j < temp.size(); j++) {
                currDist = min(currDist, abs(vh[i].f - temp[j].f) + abs(vh[i].s - temp[j].s));
            }
            total += currDist;
            if (total >= ans) break;
        }
        if (total < ans) ans = total;
        return;
    }

    for (int i = idx; i < vc.size(); i++) {
        temp.push_back(vc[i]);
        go(i + 1);
        temp.pop_back();
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    go(0);
    output();
}