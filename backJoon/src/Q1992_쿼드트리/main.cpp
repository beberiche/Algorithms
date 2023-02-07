#include <iostream>
#include <string>
using namespace std;
string ans;
int N, arr[65][65];
void input() {
    cin >> N;
    string str;
    for (int i = 1; i <= N; i++) {
        cin >> str;
        for (int j = 1; j <= N; j++) {
            arr[i][j] = str[j - 1] - '0';
        }
    }
}
void dvcq(int r, int c, int size) {
    int comp = arr[r][c];
    bool check = true;
    for (int i = r; i < r + size; i++) {
        for (int j = c; j < c + size; j++) {
            if (comp != arr[i][j]) {
                check = false;
                break;
            }
        }
        if (!check)
            break;
    }

    if (check) {
        ans += to_string(comp);
        return;
    }

    ans += "(";
    size /= 2;
    dvcq(r, c, size);
    dvcq(r, c + size, size);
    dvcq(r + size, c, size);
    dvcq(r + size, c + size, size);
    ans += ")";
}

void output() { cout << ans; }

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    dvcq(1, 1, N);
    output();
    return 0;
}