//
// Created by 김종현 on 2023/04/22.
//
#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=0; i<scoville.size(); i++) {
        pq.push(scoville[i]);
    }

    while(!pq.empty()) {
        int curr = pq.top();
        if(K > curr) {
            if(pq.size()<2) return -1;
            pq.pop();
            int curr2 = pq.top();
            pq.pop();
            pq.push(curr+curr2*2);
            answer++;
        } else {
            return answer;
        };
    }
}