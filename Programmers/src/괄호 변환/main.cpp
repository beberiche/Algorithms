//
// Created by 김종현 on 2023/03/28.
//
#include <string>
#include <stack>
#include <iostream>

using namespace std;

bool check_right(string str) {
    stack<char> s;
    for (int i = 0; i < str.size(); i++) {
        if (s.size() > 0 && s.top() == '(' && str[i] == ')') s.pop();
        else s.push(str[i]);
    }
    return s.empty() ? true : false;
}

string solve(string str) {
    if (str == "") return "";

    int cnt_open = str[0] == '(' ? 1 : 0;
    int cnt_close = str[0] == ')' ? 1 : 0;
    string u = "";
    string v = "";
    for (int i = 1; i < str.size(); i++) {
        if (str[i] == '(') cnt_open++;
        else cnt_close++;
        if (cnt_open == cnt_close) {
            u = str.substr(0, i + 1);
            v = str.substr(i + 1, str.size());
            break;
        }
    }
    if (check_right(u)) return u + solve(v);
    string change_str = "";
    for (int i = 1; i < u.size() - 1; i++) {
        change_str += u[i] == '(' ? ')' : '(';
    }
    return '(' + solve(v) + ')' + change_str;
}


string solution(string p) {
    string answer = "";
    return solve(p);
}

int main() {
    cout << solution("(()())()") << "\n";
//    cout << solution(")(") << "\n";
//    cout << solution("()))((()") << "\n";
}