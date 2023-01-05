#include <bits/stdc++.h>
using namespace std;
string s;
string ret;
int main() {
    getline(cin, s);
    for (int i = 0; i < s.size(); i++) {
        if (s[i] >= 'a')
            ret += s[i] >= 'a' + 13 ? s[i] - 13 : s[i] + 13;
        else if (s[i] >= 'A')
            ret += s[i] >= 'A' + 13 ? s[i] - 13 : s[i] + 13;
        else
            ret += s[i];
    }
    cout << ret;
}