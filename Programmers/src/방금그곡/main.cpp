//
// Created by 김종현 on 2023/05/04.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<string> v;
vector<string> st, ed;

vector<string> split(string str, char deli) {
    int idx = 0;
    vector<string> temp;
    string curr = "";
    while(idx < str.size()) {
        if(str[idx]==deli) {
            temp.push_back(curr);
            curr = "";
        } else {
            curr += str[idx];
        }
        idx++;
    }
    temp.push_back(curr);
    return temp;
}
void replaceAll(string &m, string from, string to) {
    int pos = 0;
    while((pos=m.find(from))!= -1) {
        m.replace(pos,from.length(), to);
    }
}

void change(string &str) {
    replaceAll(str,"A#", "a");
    replaceAll(str,"C#", "c");
    replaceAll(str,"D#", "d");
    replaceAll(str,"F#", "f");
    replaceAll(str,"G#", "g");
}

string solution(string m, vector<string> musicinfos) {
    change(m);
    pair<string, int> answer = {"(None)", 0};
    for(int i=0; i<musicinfos.size(); i++) {
        v = split(musicinfos[i], ',');
        st = split(v[0], ':');
        ed = split(v[1], ':');
        change(v[3]);
        // 재생시간
        int curr_time = (stoi(ed[0])*60+stoi(ed[1])) - (stoi(st[0])*60+stoi(st[1]));
        // 현재음악길이
        string curr_str = "";
        int idx = 0;
        while(idx<curr_time) {
            curr_str+=v[3][idx%v[3].size()];
            idx++;
        }
        if(curr_str.find(m) != string::npos) {
            if(answer.second < curr_time) {
                answer.first = v[2];
                answer.second = curr_time;
            }
        }
    }
    return answer.first;
}


