//
// Created by 김종현 on 2023/04/12.
//
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    int l = 0, r= people.size()-1;
    while(l<=r) {
        if(people[l]+people[r]<=limit) l++,r--;
        else r--;
        answer++;
    }
    return answer;
}