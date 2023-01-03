//kundol
#include <bits/stdc++.h>
using namespace std;
int a[9], sum;
vector<int> ret;
pair<int, int> p;

void printRet() {
    for(int i=0; i<ret.size(); i++) {
        cout << ret[i] << "\n";
    }    
}

void comb(int d, int n, int r, int idx) {
    for(int i=0; i<9; i++) {
        for(int j=i+1; j<9; j++) {
            if(sum - a[i] - a[j] == 100) {
                p = {i,j};
                return;
            }
        }
    }
}

int main() {
    for(int i=0; i<9; i++) {
        cin >> a[i];
        sum += a[i];
    }
    comb(0,9,2,0);
    for(int i=0; i<9; i++) {
        if(i == p.first || i== p.second) continue;
        ret.push_back(a[i]);
    }
    sort(ret.begin(), ret.end());
    printRet();
}