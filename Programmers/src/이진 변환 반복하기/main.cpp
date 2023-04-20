//
// Created by 김종현 on 2023/04/14.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
int cnt,zcnt;
string toBinary(int num) {
    if(num == 1) return to_string(1);
    return to_string(num%2) + toBinary(num/2);
}

void solve(string s) {
    if(s=="1") return;
    // 0 제거;
    string tmp = "";
    for(int i=0; i<s.size(); i++) {
        if(s[i]=='1') tmp+='1';
        else zcnt++;
    }
    // 이진변환
    string ret = toBinary(tmp.size());
    solve(ret);
    cnt++;
}

vector<int> solution(string s) {
    solve(s);
    return {cnt, zcnt};
}