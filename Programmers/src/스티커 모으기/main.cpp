//
// Created by 김종현 on 2023/04/14.
//
#include <iostream>
#include <vector>
using namespace std;
const int MAX = 100000;
int sum[MAX+4];

int solution(vector<int> sticker)
{

    if(sticker.size()==1) return sticker[0];
    sum[0] = sticker[0];
    sum[1] = sticker[0];
    for(int i=2; i<sticker.size()-1; i++) {
        sum[i] = max(sum[i-2]+sticker[i], sum[i-1]);
    }
    int temp = sum[sticker.size()-2];
    sum[0] = 0;
    sum[1] = sticker[1];
    for(int i=2; i<sticker.size(); i++) {
        sum[i] = max(sum[i-2]+sticker[i], sum[i-1]);
    }
    return max(temp, sum[sticker.size()-1]);
}