#include <bits/stdc++.h>
using namespace std;
string cmp, s, l, r, cl, cr;
int n;
int main() {
    cin >> n;
    cin >> cmp;
    int idx = cmp.find('*');
    l = cmp.substr(0, idx);
    r = cmp.substr(idx + 1, cmp.size());
    while (--n >= 0) {
        cin >> s;

        if (l.size() + r.size() > s.size()) {
            cout << "NE"
                 << "\n";
            continue;
        }

        cl = s.substr(0, l.size());
        cr = s.substr(s.size() - r.size(), s.size());
        if (l == cl && r == cr) {
            cout << "DA"
                 << "\n";
        } else {
            cout << "NE"
                 << "\n";
        }
    }
}