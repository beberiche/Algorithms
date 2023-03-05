//
// Created by 김종현 on 2023/03/05.
//
#include <vector>
#include <iostream>

using namespace std;
vector<int> temp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
vector<int> answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int diff = 0;

bool check() {
    for (int i = 10; i >= 0; i--) {
        if (temp[i] > answer[i]) return true;
        else if (temp[i] < answer[i]) return false;
    }
}

void dfs(int n, vector<int> &info, int idx, int sum, int cnt, int ap_sum) {
    if (n < cnt) return;
    else if (n == cnt) {
        if (sum > ap_sum) {
            if (diff <= sum - ap_sum) {
                if (diff == sum - ap_sum && !check()) return;
                diff = sum - ap_sum;
                for (int i = 0; i < answer.size(); i++) answer[i] = temp[i];
            }
        }
        return;
    }

    for (int i = idx; i < info.size(); i++) {
        temp[i] = info[i] + 1;
        if (info[i] == 0) {
            dfs(n, info, i + 1, sum + 10 - i, cnt + temp[i], ap_sum);
        } else {
            if (i == 10 && n > cnt) {
                temp[i] = n - cnt;
                dfs(n, info, i + 1, sum, n, ap_sum);
            } else {
                dfs(n, info, i + 1, sum + 10 - i, cnt + temp[i], ap_sum - (10 - i));
            }
        }
        temp[i] = 0;
    }
}

vector<int> solution(int n, vector<int> info) {
    int ap_sum = 0;
    for (int i = 0; i < info.size(); i++) {
        if (info[i] > 0) {
            ap_sum += 10 - i;
        }
    }
    dfs(n, info, 0, 0, 0, ap_sum);
    if (diff == 0) return {-1};
    return answer;
}

void print_v(vector<int> v) {
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << " ";
    }
}

int main() {
//    print_v(solution(5, {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
//    print_v(solution(1, {1,0,0,0,0,0,0,0,0,0,0}));
//    print_v(solution(9, {0,0,1,2,0,1,1,1,1,1,1}));
//    print_v(solution(10, {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}));
}