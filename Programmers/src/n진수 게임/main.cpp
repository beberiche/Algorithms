//
// Created by 김종현 on 2023/04/24.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
char arr[16] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
string go(int num, int n) {
    if(num==1 || num==0) return to_string(num);
    string str;
    str = arr[num%n];
    int d = num/n;
    return (d == 0 ?  "" : go(num/n, n))+str;
}
string solution(int n, int t, int m, int p) {
    string answer = "";
    int num = 0;
    int idx = 1;
    while(true) {
        string temp = go(num++, n);
        string str = temp == "" ? "0" : temp;
        for(int j=0; j<str.size(); j++) {
            if((idx%m)==(p%m)) {
                answer+=str[j];
                if(answer.size() == t) break;
            }
            idx++;
        }
        if(answer.size() == t) break;
    }
    return answer;
}
