#include <iostream>
#include <string.h>
using namespace std;
int N, L, ans;
int ar[101][101], ac[101][101];
int visited[101];
string s;
void input() {
    cin >> N >> L;
    for (int i = 0; i < N; i++) {
        s = "";
        for (int j = 0; j < N; j++) {
            cin >> ac[i][j];
            ar[j][i] = ac[i][j];
        }
    }

}

void solve(int a[101][101]) {
    for (int i = 0; i < N; i++) {
        bool check = true;
        memset(visited, 0, sizeof(visited));
        for (int j = 0; j < N - 1; j++) {
            if (a[i][j] == a[i][j + 1] + 1) {
                int curr = a[i][j + 1];
                for (int k = j + 1; k <= j + L; k++) {
                    if (k >= N || a[i][k] != curr || visited[k]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int k = j + 1; k <= j + L; k++) visited[k] = 1;
                }
            } else if (a[i][j] == a[i][j + 1] - 1) {
                int curr = a[i][j];
                for (int k = j - L + 1; k <= j; k++) {
                    if (k < 0 || a[i][k] != curr || visited[k]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int k = j - L + 1; k <= j; k++) visited[k] = 1;
                }
            } else if (a[i][j] - a[i][j + 1] < -1 || a[i][j] - a[i][j + 1] > 1) {
                check = false;
                break;
            }
        }
        if (check) {
            ans++;
        }
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve(ac);
    solve(ar);
    output();
}

