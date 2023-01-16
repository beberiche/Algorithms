#include <bits/stdc++.h>
using namespace std;
typedef map<string, int> mp;
int t, n;
int main() {
    cin >> t;
    while (t--) {
        mp m;
        cin >> n;
        while (n--) {
            string tmpK, tmpV;
            cin >> tmpV >> tmpK;
            if (m.find(tmpK) == m.end())
                m.insert({tmpK, 1});
            else
                m[tmpK]++;
        }
        int ans = 1;
        for (auto i : m)
            ans *= (i.second + 1);
        ans -= 1;
        cout << ans << "\n";
    }
}