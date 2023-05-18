//
// Created by 김종현 on 2023/05/17.
//
#include <iostream>
#include <vector>

using namespace std;
int N;

int go(string str, int l, int r, bool check) {
    while (l < r) {
        if (str[l++] != str[r--]) {
            if (check) {
                if (go(str, l, r + 1, false) == 0) return 1;
                else if (go(str, l - 1, r, false) == 0) return 1;
            }
            return 2;
        }
    }
    return 0;
}

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        cout << go(str, 0, str.size() - 1, true) << "\n";
    }
}


int main() {
    input();
}