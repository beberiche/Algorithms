//
// Created by 김종현 on 2023/04/20.
//
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int MAX;

void maxPriority(vector<int> &v) {
    MAX = 0;
    for(int i=0; i<v.size(); i++) {
        MAX = max(MAX, v[i]);
    }
}

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int, int>> q;
    for(int i=0; i<priorities.size(); i++) {
        q.push({i,priorities[i]});
    }
    maxPriority(priorities);

    while(!q.empty() && MAX != 0) {
        pair<int,int> curr = q.front();
        q.pop();
        if(curr.second != MAX) {
            q.push(curr);
        } else {
            answer++;
            if(curr.first == location) return answer;
            priorities[curr.first] = -1;
            maxPriority(priorities);
        }
    }
}

int main() {
    cout << solution({2,1,3,2}, 2) << "\n";
    cout << solution({1,1,9,1,1,1},0) << "\n";
}