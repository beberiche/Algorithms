//
// Created by 김종현 on 2023/07/05.
//
#include <iostream>
#include <unordered_set>

using namespace std;
int N, M, p[1004 * 1004];
char a[1004][1004];
unordered_set<int> s;

// SAFE ZONE은 결국,
// 사람들이 무한적으로 움직이게 되는 경우에 이를 멈추기 위해 필요하다.
// 즉 해당 입력값에 사이클이 몇개인지를 묻는 문제이다.
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        for (int j = 0; j < M; j++) {
            a[i][j] = str[j];
            p[i * M + j] = i * M + j;
        }
    }
}

int find(int num) {
    if (num == p[num]) return num;
    return p[num] = find(p[num]);
}

void setUnion(int n1, int n2) {
    int x = find(n1);
    int y = find(n2);

    if (x < y) p[y] = x;
    else p[x] = y;
}


void solve() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int nr = i, nc = j;
            if (a[i][j] == 'U') nr--;
            else if (a[i][j] == 'D') nr++;
            else if (a[i][j] == 'L') nc--;
            else nc++;

            setUnion(i * M + j, nr * M + nc);
        }
    }
}

void output() {
    int ans = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (p[i * M + j] == i * M + j) ans++;
        }
    }
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}