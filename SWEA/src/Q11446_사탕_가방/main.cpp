#include <algorithm>
#include <iostream>

using namespace std;
typedef long long ll;
ll arr[101];
int main(int argc, char **argv) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin >> T;
    int N;
    ll M, l, r, mid, sum;
    for (int t = 1; t <= T; t++) {
        cin >> N >> M;
        r = mid = 0;
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
            r = max(r, arr[i]);
        }
        l = 1;
        while (l <= r) {
            mid = (l + r) / 2;
            sum = 0;
            for (int i = 0; i < N; i++)
                sum += (arr[i] / mid);
            if (sum < M)
                r = mid - 1;
            else
                l = mid + 1;
        }
        cout << "#" << t << " " << r << "\n";
    }
}