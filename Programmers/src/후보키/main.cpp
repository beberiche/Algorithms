#include <unordered_set>
#include <string>
#include <vector>
using namespace std;
vector<int> v;
unordered_set<string> ss;

bool check(int idx) {
    for(auto i : v) {
        if((i&idx)==i) return false;
    }
    return true;
}

int solution(vector<vector<string>> relation) {
    int answer = 0;
    for(int i=1; i< (1 << relation[0].size()); i++) {
        if(!check(i)) continue;
        ss.clear();
        for(int j=0; j<relation.size(); j++) {
            string curr = "";
            for(int k=0; k<relation[0].size(); k++) {
                if(((1 << k) & i) > 0) curr += relation[j][k];
            }
            int prev_len = ss.size();
            ss.insert(curr);
            if(prev_len==ss.size()) break;
        }
        if(ss.size() == relation.size()) v.push_back(i);
    }

    return v.size();
}