#include <bits/stdc++.h>
using namespace std;

bool check(string s) {
    int l = 0;
    int r = s.size() - 1;

    while (l <= r) {
        cout << s << " " << s[l] << " " << s[r] << "\n";
        if (s[l] != s[r])
            return false;
        l++;
        r--;
    }
    return true;
}

int main() {
    string s;
    cin >> s;
    int ret = check(s) ? 1 : 0;
    cout << ret;
}