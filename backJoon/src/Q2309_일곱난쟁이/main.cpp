#include <bits/stdc++.h>
using namespace std;
int arr[9];
vector<int> temp;

void printV() {
    for(int i=0; i<temp.size(); i++) {
        cout << temp[i] << "\n"; 
    }
    exit(0);
}

void comb(int d, int n, int r, int idx) {
    if(d>=r) {
        if(accumulate(temp.begin(), temp.end(), 0)==100) printV();
        return;
    }
        
    for(int i=idx; i<n; i++) {
        temp.push_back(arr[i]);
        comb(d+1, n,r,idx+1);
        temp.pop_back();
    }
}

int main() {
    for(int i=0; i<9; i++) {
        cin >> arr[i];
    }
    sort(arr, arr+9);
    comb(0,9,7,0);
    return 0; 
}