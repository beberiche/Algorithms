//
// Created by 김종현 on 2023/04/25.
//
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
unordered_map<string, string> m;

vector<string> split(string str) {
    vector<string> v;
    string temp = "";
    int idx = -1;
    while(++idx != str.size()) {
        if(str[idx] == ' ') v.push_back(temp),temp = "";
        else temp += str[idx];
    }
    v.push_back(temp);
    return v;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    // split을 통한 vector<string> 반환
    for(int i=0; i<record.size(); i++) {
        vector<string> sp_v = split(record[i]);
        string cmd = sp_v[0];
        // Enter : map에 이름을 등록 혹은 수정, answer에 "id + 님이 들어왔습니다." 추가
        // Leave : answer에 "id + 님이 나갔습니다." 추가.
        // Change : map에 이름 수정
        if(cmd == "Enter") {
            m[sp_v[1]] = sp_v[2];
            answer.push_back(sp_v[1]+" 님이 들어왔습니다.");
        } else if(cmd == "Leave") {
            answer.push_back(sp_v[1]+" 님이 나갔습니다.");
        } else {
            m[sp_v[1]] = sp_v[2];
        }
    }


    // id를 최종적으로 남은 map의 이름으로 바꾸기.
    for(int i=0; i<answer.size(); i++) {
        vector<string> temp = split(answer[i]);
        answer[i] = m[temp[0]]+temp[1]+ " "+ temp[2];
    }
    return answer;
}