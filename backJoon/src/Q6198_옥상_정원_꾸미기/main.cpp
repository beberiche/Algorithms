#include<iostream>
#include<vector>

using namespace std;
int N;
long long ans;
vector<int> v;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    cin >> num;
    v.push_back(num);
    for (int i = 1; i < N; i++) {
        cin >> num;
        if (v.back() <= num) {
            int l = 0;
            int r = v.size() - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (v[mid] <= num) r = mid;
                else l = mid + 1;
            }
            if (!r) v.clear();
            v.assign(v.begin(), v.begin()+r);
        }
        v.push_back(num);
        ans += v.size() - 1;
    }
    cout << ans;
}