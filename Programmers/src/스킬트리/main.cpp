//
// Created by 김종현 on 2023/05/01.
//
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
unordered_map<char,int> m;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    for(int i=0; i<skill.size(); i++) {
        m[skill[i]]=i;
    }
    for(int i=0; i<skill_trees.size(); i++) {
        int idx = -1;
        bool check = true;
        for(int j=0; j<skill_trees[i].size(); j++) {
            if(m.find(skill_trees[i][j])!=m.end()) {
                if(m[skill_trees[i][j]] == idx+1) {
                    idx = idx+1;
                } else {
                    check = false;
                    break;
                }
            }
        }
        if(check) answer++;
    }
    return answer;
}