//
// Created by 김종현 on 2023/05/22.
//
#include <iostream>
using namespace std;
int main() {
    int N;
    int ans = 0;
    for(int i=0; i<5; i++) {
        cin >> N;
        ans+=N*N%10;
    }
    cout << ans%10;
}