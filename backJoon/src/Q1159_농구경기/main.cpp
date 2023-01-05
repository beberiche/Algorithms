#include <bits/stdc++.h>
using namespace std;
int n;
int a[26];
int main() {
    cin >> n;
    string s;
    bool check = false;
    while (--n >= 0) {
        cin >> s;
        a[s[0] - 97]++;
    }

    for (int i = 0; i < 26; i++) {
        if (a[i] > 4) {
            cout << (char)(i + 97);
            check = true;
        }
    }
    if (!check)
        cout << "PREDAJA";
}