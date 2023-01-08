#include <bits/stdc++.h>
using namespace std;
int arr[200004];
int sum[200004];

int main() {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, x, y;
    cin >> N >> x >> y;

    for (int i = 0; i < N; i++) {
        if (arr[i] == 0)
            cin >> arr[i];
        for (int j = i + 1; j < N; j++) {
            if (arr[j] == 0)
                cin >> arr[j];
            int n = arr[i] - arr[j];
            if (n < 0) {
                int dv = (n * -1) / x + 1;
                sum[i] += (dv * y);
            } else if (n > 0) {
                int dv = n / x + 1;
                sum[j] += (dv * y);
            }
        }
        if (i > 0) {
            sum[i] += sum[i - 1];
            sum[i] %= 998244353;
        }
    }

    cout << sum[N - 1] << " " << sum[0];
}