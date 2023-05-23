//
// Created by 김종현 on 2023/05/23.
//
#include <iostream>
using namespace std;
string S;

int main() {
    while (true) {
        cin >> S;
        if(S == "0") break;
        int l = 0;
        int r = S.size() - 1;
        bool check = true;
        while (l <= r) {
            if (S[l++] != S[r--]) {
                check = false;
                break;
            }
        }
        cout << (check ? "yes" : "no") << "\n";
    }
}