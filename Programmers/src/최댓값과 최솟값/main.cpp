//
// Created by 김종현 on 2023/04/14.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<string> split(string s, char deli) {
    vector<string> tmp;
    string curr = "";
    for(int i=0; i<s.size(); i++) {
        if(s[i]==deli) {
            tmp.push_back(curr);
            curr = "";
        } else {
            curr += s[i];
        }
    }
    if(curr.size()>0) tmp.push_back(curr);
    return tmp;
}

string solution(string s) {
    string answer = "";
    vector<string> sp = split(s, ' ');
    int min_ans = 999999;
    int max_ans = -999999;
    for(auto a : sp) {
        max_ans = max(max_ans, stoi(a));
        min_ans = min(min_ans, stoi(a));
    }
    return to_string(min_ans) + " " + to_string(max_ans);
}