#include <bits/stdc++.h>
using namespace std;
int N;
string x, y;
int main() {
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N >> x >> y;
        string ans = "";
        cout << x + y << "\n";
        if (N < stoi(x + y)) {
            ans = "-1";
        }
        cout << "#" << t << " " << stoi(ans) << "\n";
    }
}