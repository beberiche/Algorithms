//
// Created by 김종현 on 2023/04/19.
//
#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;
set<int> s;
int solution(vector<int> elements) {
    int answer = 0;
    int len = elements.size();
    for(int i=0; i<len; i++) {
        elements.push_back(elements[i]);
    }
    for(int i=1; i<=len; i++) {
        for(int j=0; j<len; j++) {
            int sum = 0;
            for(int k=j; k<j+i; k++) {
                sum+=elements[k];
            }
            s.insert(sum);
        }
    }
    return s.size();
}