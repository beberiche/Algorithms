//
// Created by 김종현 on 2023/04/14.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    char prev;
    s[0] = s[0] >= 97 && s[0] <= 122 ? char(s[0]-32) : s[0];
    for(int i=1; i<s.size(); i++) {
        if(prev == ' ') s[i] = s[i] >= 97 && s[i] <= 122 ? char(s[i]-32) : s[i];
        else s[i] = s[i] >=65 && s[i] <= 90 ? char(s[i]+32) : s[i];
        prev = s[i];
    }
    return s;
}