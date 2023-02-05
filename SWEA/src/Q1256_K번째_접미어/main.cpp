#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int idx = 0;
        cin >> idx;
        string str;
        cin >> str;

        vector<string> v;
        for (int i = 0; i < str.size(); ++i) {
            v.push_back(str.substr(i));
        }
        sort(v.begin(), v.end());
        cout << "#" << t << " " << v[--idx] << "\n";
    }
    return 0;
}