// kundol
#include <bits/stdc++.h>
using namespace std;
int a[9];
int main() {
    for(int i=0; i<sizeof(a)/sizeof(int); i++) {
        cin >> a[i];
    }

    sort(a,a+9);
    do {
        int sum = 0;
        for(int i=0; i<7;i++) sum+=a[i];
        if(sum == 100) break;
    } while(next_permutation(a,a+9));

    for(int i=0; i<7; i++) cout << a[i] << "\n";
    return 0;
}
