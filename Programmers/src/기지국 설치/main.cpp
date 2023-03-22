//
// Created by 김종현 on 2023/03/22.
//
#include <iostream>
#include <vector>
using namespace std;
int sp,st,ed;
int solve(int st, int ed) {
    if(st>ed) return 0;
    int cnt = ed-st+1;
    return cnt%sp ==0 ? cnt/sp : cnt/sp+1;
}
int solution(int n, vector<int> stations, int w) {
    int answer = 0;
    sp = 2*w+1; // spread -> 전체 전파 값, ex) w=1, sp=3 / w=2, sp=5;
    answer += solve(1,stations.front()-w-1) + solve(stations.back()+w+1,n);
    for(int i=1; i<stations.size(); i++){
        st = stations[i-1]+w+1, ed = stations[i]-w-1;
        answer += solve(st,ed);
    }
    return answer;
}