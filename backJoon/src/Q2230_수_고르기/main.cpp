#include <algorithm>
#include <bits/stdc++.h>
#include <iostream>
#define MAX 2000000001
using namespace std;
int N, M, st, ed;
int arr[100000];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        cin >> arr[i];
    sort(arr, arr + N);
    int res = MAX;
    while (st < N && ed < N && st <= ed) {
        int diff = arr[ed] - arr[st];
        if (diff < M)
            ed++;
        else {
            res = min(res, diff);
            st++;
        }
    }
    cout << res;
}