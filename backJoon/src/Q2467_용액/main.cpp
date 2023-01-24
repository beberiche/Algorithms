#include <bits/stdc++.h>
using namespace std;
vector<int> arr;
int N, tmp, l, r, sum, ansL, ansR;
int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> tmp;
        arr.push_back(tmp);
    }
    l = ansL = 0;
    r = ansR = N - 1;
    sum = abs(arr[l] + arr[r]);
    while (l < r) {
        int mid = arr[l] + arr[r];
        if (sum > abs(mid)) {
            sum = abs(mid);
            ansL = l;
            ansR = r;
        }
        if (mid < 0)
            l++;
        else
            r--;
    }
    cout << arr[ansL] << " " << arr[ansR];
}