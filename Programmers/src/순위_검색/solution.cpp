#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

vector<string> split(string str, string deli) {
    vector<string> result;
    long long pos = 0;
    string token;
    while ((pos = str.find(deli)) != string::npos) {
        token = str.substr(0, pos);
        result.push_back(token);
        str.erase(0, pos + deli.length());
    }
    pos = 0;
    token = "";
    while ((pos = str.find(" ")) != string::npos) {
        token = str.substr(0, pos);
        result.push_back(token);
        str.erase(0, pos + 1);
    }
    result.push_back(str);
    return result;
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;
    map<string, vector<int>> db;
    for (auto i: info) {
        vector<string> curr_info = split(i, " ");
        for (int j = 0; j < 16; j++) {
            string tmp = "";
            for (int k = 0; k < 4; k++)
                tmp += (j & (1 << k)) ? curr_info[k] : "-";
            db[tmp].push_back(stoi(curr_info[4]));
        }
    }

    for (auto &v: db) sort(v.second.begin(), v.second.end());

    for (auto q: query) {
        vector<string> curr_query = split(q, " and ");
        string key = curr_query[0] + curr_query[1] + curr_query[2] + curr_query[3];
        vector<int> scores = db[key];
        answer.push_back(scores.end() - lower_bound(scores.begin(), scores.end(), stoi(curr_query[4])));
    }

    return answer;
}

int main() {
    vector<int> tmp = solution({"java backend junior pizza 150", "python frontend senior chicken 210",
                                "python frontend senior chicken 150", "cpp backend senior pizza 260",
                                "java backend junior chicken 80",
                                "python backend senior chicken 50"},
                               {"java and backend and junior and pizza 100",
                                "python and frontend and senior and chicken 200",
                                "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                                "- and - and - and chicken 100", "- and - and - and - 150"});

    for (auto i: tmp) {
        cout << i << " ";
    }
}

