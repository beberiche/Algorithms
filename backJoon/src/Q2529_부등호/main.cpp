//
// Created by 김종현 on 2023/04/20.
//
#include <iostream>
#include <vector>
using namespace std;
int K;
vector<char> v;
vector<string> vv;
int visited[10];

void input() {
    cin >> K;
    char ch;
    for (int i = 0; i < K; i++) {
        cin >> ch;
        v.push_back(ch);
    }
}

void solve(int cnt, string str) {
    if (cnt >= K) {
        vv.push_back(str);
        return;
    }

    for (int i = 0; i <= 9; i++) {
        if (visited[i]) continue;
        visited[i]++;
        if (v[cnt] == '<' && str[cnt] - '0' < i) {
            solve(cnt + 1, str + to_string(i));
        } else if (v[cnt] == '>' && str[cnt] - '0' > i) {
            solve(cnt + 1, str + to_string(i));
        }
        visited[i]--;
    }
}

void output() {
    cout << vv[vv.size() - 1] << "\n" << vv[0];
}

int main() {
    input();
    for (int i = 0; i <= 9; i++) {
        visited[i]++;
        solve(0, to_string(i));
        visited[i]--;
    }
    output();
}