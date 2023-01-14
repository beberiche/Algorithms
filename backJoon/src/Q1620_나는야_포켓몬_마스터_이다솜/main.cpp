#include <bits/stdc++.h>
using namespace std;
int N, M;
string n, tmp;
map<string, int> m;
string m2[100000 + 1];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);

    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        cin >> n;
        m.insert({n, i});
        m2[i] = n;
    }

    while (--M >= 0) {
        cin >> tmp;
        if (atoi(tmp.c_str()) != 0) {
            cout << m2[atoi(tmp.c_str())] << "\n";
        } else {
            cout << m[tmp] << "\n";
        }
    }
}
