//
// Created by 김종현 on 2023/04/05.
//
#include <iostream>
#include <vector>

using namespace std;
int N, ans=-987654321;
vector<char> v;
vector<int> n;

void input() {
    string str;
    cin >> N >> str;
    for (int i = 0; i < N; i++) {
        if (str[i] == '-' || str[i] == '*' || str[i] == '+') v.push_back(str[i]);
        else n.push_back(str[i] - '0');
    }
}

int cal(int fr, char op, int back) {
    switch (op) {
        case '+' :
            return fr + back;
        case '-' :
            return fr - back;
        case '*' :
            return fr * back;
    }
}

void dfs(int idx, int num) {
    if (idx >= N / 2) {
        ans = max(ans, num);
        return;
    }

    dfs(idx + 1, cal(num, v[idx], n[idx + 1]));

    if (idx + 2 <= N / 2) dfs(idx + 2, cal(num, v[idx], cal(n[idx + 1], v[idx + 1], n[idx + 2])));
}

void output() {
    cout << ans;
}


int main() {
    input();
    dfs(0, n[0]);
    output();
}