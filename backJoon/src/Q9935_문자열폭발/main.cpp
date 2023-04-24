//
// Created by 김종현 on 2023/04/24.
//
#include <iostream>

using namespace std;
string str1, str2,str;

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> str1 >> str2;
}

void solve() {
    for (int i = 0; i < str1.size(); i++) {
        str += str1[i];
        if(str.size() >= str2.size() && str.substr(str.size()-str2.size(), str2.size()) == str2) {
            str.erase(str.end()-str2.size(), str.end());
        }
    }
}

void output() {
    cout << (str == "" ? "FRULA": str);
}

int main() {
    input();
    solve();
    output();
}