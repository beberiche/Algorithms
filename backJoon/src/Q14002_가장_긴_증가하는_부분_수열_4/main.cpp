//
// Created by 김종현 on 2023/04/23.
//
#include<iostream>
#include<vector>

using namespace std;
int N, ret = 1, idx;
vector<int> v, vv, cnt;
void input() {
    cin >> N;
    int num;
    for (int i = 0; i < N; i++) cin >> num, v.push_back(num);
    vv = vector<int>(1004, -1);
    cnt = vector<int>(1004, 1);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (v[j] < v[i] && cnt[i] < cnt[j] + 1) {
                cnt[i] = cnt[j] + 1;
                vv[i] = j;
                if(ret < cnt[i]) {
                    ret = cnt[i];
                    idx= i;
                }
            }
        }
    }
}

void go(int idx) {
    if(idx == -1) return;
    go(vv[idx]);
    cout << v[idx] << " ";
}

void output() {
    cout << ret << "\n";
    go(idx);
}

int main() {
    input();
    output();
}
