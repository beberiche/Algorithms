//
// Created by 김종현 on 2023/04/16.
//
#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> a;
    int total = brown+yellow;
    for(int i=1; i<=total; i++) {
        if(total%i==0 && (total/i-2) * (i-2)==yellow) {
            if(i > (total/i)) a.push_back(i), a.push_back(total/i);
            else a.push_back(total/i), a.push_back(i);
            break;
        }
    }
    return a;
}