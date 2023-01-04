#include <bits/stdc++.h>
using namespace std;

int al[26];
string str;
int main() {
    cin >> str;
    for(int i=0; i<str.size(); i++) {
        al[str[i]-97]++;
    }
    for(int a : al) {
        cout << a << " ";
    }
    return 0;
}