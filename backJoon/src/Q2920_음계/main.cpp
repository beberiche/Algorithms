#include <iostream>
using namespace std;
int main() {
    string s;
    int n;
    for(int i=0; i<8; i++) {
        cin >> n;
        s+= to_string(n);
    }

    if(s=="12345678") cout << "ascending";
    else if(s=="87654321") cout << "descending";
    else cout << "mixed";
}