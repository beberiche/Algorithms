#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> split(string s, int cnt) {
    vector<string> temp;
    int idx=-1;
    string ts="";
    while(++idx<s.size()) {
        ts += s[idx];
        if(ts.size()==cnt) {
            temp.push_back(ts);
            ts = "";
        }
    }
    temp.push_back(ts);
    return temp;
}

int solution(string s) {
    int answer = s.size();
    vector<string> v_sp;
    for(int i=1; i<=v_sp.size()/2; i++) {
        v_sp = split(s,i);
        string prev = v_sp[0];
        int curr_cnt = 0;
        string curr_str = "";
        for(int i=1; i<v_sp.size(); i++) {
            if(curr_str.size()>answer) break;
            if(prev == v_sp[i]) {
                curr_cnt++;
            } else {
                curr_str += (!curr_cnt ? "" : to_string(curr_cnt+1))+prev;
                curr_cnt = 0;
            }
            prev = v_sp[i];
        }
        curr_str += (!curr_cnt ? "" : to_string(curr_cnt+1))+prev;
        answer = min(answer, (int)curr_str.size());
    }
    return answer;
}