//
// Created by 김종현 on 2023/05/02.
//
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
vector<string> go(string str) {
    int idx = 0;
    string tmp = "";
    string num = "";
    vector<string> s;
    while(idx != str.size()) {
        if('0'<=str[idx] && str[idx]<='9') {
            num+=str[idx];
        } else {
            if(num!="") break;
            tmp+=tolower(str[idx]);
        }
        idx++;
    }
    s.push_back(tmp);
    s.push_back(to_string(stoi(num)));
    return s;
}

struct File {
    int i;
    string h;
    int n;
    string s;
};

bool cmp(File a, File b) {
    if(a.h == b.h && a.n == b.n) return a.i < b.i;
    else if(a.h == b.h) return a.n < b.n;
    return a.h < b.h;
}

vector<string> solution(vector<string> files) {
    vector<File> tmp;
    vector<string> answer;
    for(int i=0; i<files.size(); i++) {
        vector<string> s = go(files[i]);
        File f;
        f.i = i;
        f.h = s[0];
        f.n = stoi(s[1]);
        f.s = files[i];
        tmp.push_back(f);
    }
    sort(tmp.begin(), tmp.end(), cmp);
    for(File a : tmp) {
        answer.push_back(a.s);
    }

    return answer;
}