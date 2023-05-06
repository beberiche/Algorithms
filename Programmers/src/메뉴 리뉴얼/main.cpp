#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;
unordered_map<string, int> m;
vector<char> tmp;
void comb(int idx, int len, string str) {
    if(str.size() >= len) {
        m[str]++;
        return;
    }

    string ss = "";
    for(int i=idx; i<tmp.size(); i++) {
        ss = str + tmp[i];
        comb(i+1, len, ss);
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;

    for(int i=0; i<orders.size(); i++) {
        // orders[i] 백터에 넣고 정렬
        tmp.clear();
        for(int j=0; j<orders[i].size(); j++) {
            tmp.push_back(orders[i][j]);
        }
        sort(tmp.begin(), tmp.end());
        // course 별 조합, map에 추가
        for(auto n : course) {
            if(n <= tmp.size()) comb(0, n, "");
        }
    }
    for(int i=0; i<course.size(); i++) {
        int cnt = 0;
        for(auto iter = m.begin(); iter!=m.end(); ++iter) {
            if(course[i]==iter->first.size()) cnt = max(cnt, iter->second);
        }

        if(cnt >= 2) {
            for(auto iter = m.begin(); iter!=m.end(); ++iter) {
                if(course[i]==iter->first.size() && iter->second == cnt) {
                    answer.push_back(iter->first);
                }
            }
        }
    }
    // answer 사전 순 정렬 후 출력
    sort(answer.begin(), answer.end());
    return answer;
}