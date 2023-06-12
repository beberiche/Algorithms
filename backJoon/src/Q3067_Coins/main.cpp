#include <iostream>
#include <vector>

using namespace std;
int T, N, num, money;
vector<int> v, m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> T;
    while (T--) {
        v.clear();
        m.clear();
        cin >> N;
        while (N--) {
            cin >> num;
            v.push_back(num);
        }
        cin >> money;
        vector<int> m(money + 1, 0);
        for (int mm: v) {
            m[mm]++;
            for (int j=mm+1; j<=money; j++) {
                m[j] += m[j-mm];
            }
        }
        cout << m[money] << "\n";
    }
}