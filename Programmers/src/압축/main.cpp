//
// Created by 김종현 on 2023/04/23.
//
#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;
unordered_map<string, int> m;

vector<int> solution(string msg) {
    vector<int> answer;

    // 사전 만들기
    char ch = 'A';
    string str;
    for (int i = 1; i <= 26; i++) {
        str = ch++;
        m[str] = i;
    }

    // 사전을 확인하여 존재하면 해당 idx를
    // 존재하지 않는 경우는 다음 문자를 포함하여 새로운 사전으로 등록
    int st = 0;
    int cnt = 1;
    int idx = 27;
    while (st+cnt <= msg.size()) {
        string curr = msg.substr(st, cnt);
        if (m.find(curr) != m.end()) {
            cnt++;
        } else {
            answer.push_back(m[msg.substr(st, cnt - 1)]);
            m[curr] = idx++;
            st+=cnt-1;
            cnt = 1;
        }
    }
    answer.push_back(m[msg.substr(st, cnt - 1)]);
    return answer;
}

int main() {
    //solution("KAKAO");
    //solution("TOBEORNOTTOBEORTOBEORNOT");
    solution("ABABABABABABABAB");
}