//
// Created by 김종현 on 2023/04/15.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;

int toBinary(int n) {
    if(n==1) return 1;
    int ret = n%2 == 1? 1 : 0;
    return ret + toBinary(n/2);
}

int solution(int n) {
    int answer = 0;
    int cmp = toBinary(n);
    int next = n;
    while(cmp != toBinary(++next));
    return next;
}