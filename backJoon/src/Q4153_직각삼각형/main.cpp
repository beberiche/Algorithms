#include <iostream>
#include <algorithm>
using namespace std;
int a[3];
int main() {
    while(true) {
        for(int i=0; i<3; i++) cin >> a[i];
        if(a[0]==0) break;

        sort(a, a+3);
        cout << (a[0]*a[0] + a[1]*a[1] == a[2]*a[2] ? "right" : "wrong") << "\n";
    }
}