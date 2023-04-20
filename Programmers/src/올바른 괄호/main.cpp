//
// Created by 김종현 on 2023/04/14.
//
#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<char> stack;
    stack.push(s[0]);
    for(int i=1; i<s.size(); i++) {
        if(stack.size() > 0 && s[i]==')' && stack.top() == '(') {
            stack.pop();
        } else if(s[i] == '(') {
            stack.push(s[i]);
        }
    }

    return stack.size() == 0 ? true : false;
}