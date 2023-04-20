//
// Created by 김종현 on 2023/04/15.
//
#include <iostream>
#include <string>
#include <stack>

using namespace std;

int solution(string s) {
    stack<char> stack;
    stack.push(s[0]);
    for (int i = 1; i < s.size(); i++) {
        if (stack.size() > 0 && stack.top() == s[i]) {
            stack.pop();
            continue;
        }
        stack.push(s[i]);
    }
    return stack.size() ? 1 : 0;
}

int main() {
    solution("baabaa");
    solution("cdcd");
}