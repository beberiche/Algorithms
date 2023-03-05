//
// Created by 김종현 on 2023/03/05.
//
#include <iostream>
using namespace std;
int N;
int main() {
    cin >> N;
    int num = 666;
    while(true) {
        if(to_string(num++).find("666")!=string::npos) N--;
        if(N==0) break;
    }
    cout << num-1;
}