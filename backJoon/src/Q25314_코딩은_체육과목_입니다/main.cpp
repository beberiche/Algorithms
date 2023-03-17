//
// Created by 김종현 on 2023/03/16.
//
#include <iostream>
int N;
using namespace std;
int main() {
    cin >> N;
    string ans = "";
    for(int i=0; i<N/4; i++) {
        ans += "long ";
    }
    cout << ans + "int";
}