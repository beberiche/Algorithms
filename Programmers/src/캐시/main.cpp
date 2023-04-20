//
// Created by 김종현 on 2023/04/18.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;

string toLower(string s) {
    string temp = "";
    for(int i=0; i<s.size(); i++) {
        temp += tolower(s[i]);
    }
    return temp;
}

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    if(cacheSize==0) {
        return 5*cities.size();
    }
    for(int i=0; i<cities.size(); i++) {
        cities[i] = toLower(cities[i]);
    }
    vector<string> v;
    for(int i=0; i<cities.size(); i++) {
        bool check = false;
        for(int j=0; j<v.size(); j++) {
            if(cities[i]==v[j]) {
                check = true;
                v.erase(v.begin()+j);
                break;
            }
        }
        if(!check) answer+=5;
        else answer++;
        v.push_back(cities[i]);
        if(v.size() > cacheSize) v.erase(v.begin());
    }

    return answer;
}

int main() {
    solution(3, {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
}