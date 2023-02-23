//
// Created by 김종현 on 2023/02/23.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N;
vector<string> v;

bool cmp(string s1, string s2) {
    if(s1.length() == s2.length()) {
        return s1 < s2;
    }
    return s1.length() < s2.length();
}

string deleteZero(string str) {
    for(int j=0; j<str.length(); j++) {
        if(str[j]=='0') {
            if(j==str.length()-1) break;
            str.erase(0,1);
            j=-1;
        }
        else break;
    }
    return str;
}

void input() {
    cin >> N;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        string curr = "";
        for (int j = 0; j < str.length(); j++) {
            if (str[j] - 'a' >= 0) {
                if (curr.length() > 0) v.push_back(deleteZero(curr));
                curr = "";
            } else curr += str[j];
        }
        if(curr.length()>0) v.push_back(deleteZero(curr));
    }
    sort(v.begin(), v.end(), cmp);
}

void output() {
    for(auto &n : v) {
        cout << n << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    output();
}