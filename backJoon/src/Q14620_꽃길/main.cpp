//
// Created by 김종현 on 2023/04/22.
//
#include <iostream>

using namespace std;
int N, arr[11][11], visited[11][11], ans = 987654321;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
        }
    }
}

void solve(int r, int c, int cnt, int sum) {
    if (sum >= ans) return;
    if (cnt >= 3) {
        ans = min(ans, sum);
        return;
    }

    for (int i = r; i < N - 1; i++) {
        for (int j = c; j < N - 1; j++) {
            if (visited[i][j] || visited[i - 1][j] || visited[i][j - 1] || visited[i + 1][j] ||
                visited[i][j + 1])
                continue;
            visited[i][j]++, visited[i - 1][j]++, visited[i][j - 1]++, visited[i + 1][j]++, visited[i][j + 1]++;
            solve(r, c, cnt + 1, sum + arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i + 1][j] + arr[i][j + 1]);
            visited[i][j]--, visited[i - 1][j]--, visited[i][j - 1]--, visited[i + 1][j]--, visited[i][j + 1]--;
        }
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(1, 1, 0, 0);
    output();
}