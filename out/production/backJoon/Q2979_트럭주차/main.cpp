#include <bits/stdc++.h>
using namespace std;
int fee[4];
int arr[104];
int main() {
    for(int i=1; i<4; i++) {
        cin >> fee[i];
    }

    int st,ed;
    for(int i=0; i<3; i++) {
        cin >> st;
        cin >> ed;
        for(int i=st+1; i<=ed; i++) arr[i]++;
    }

    for(int i=1; i<104; i++) arr[i] = arr[i] * fee[arr[i]];
    
    
    cout << accumulate(arr, arr+104, 0);
}