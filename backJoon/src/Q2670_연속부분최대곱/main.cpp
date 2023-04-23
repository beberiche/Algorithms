//
// Created by 김종현 on 2023/04/23.
//
#include <iostream>
#include <vector>

using namespace std;
int N;
vector<double> v, vv;
double ans;

void input() {
    cin >> N;
    double num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }

//    for (int i = 0; i < N; i++) {
//        vv = vector<double>(N, 0);
//        vv[i] = v[i];
//        ans = max(vv[i], ans);
//        for (int j = i + 1; j < N; j++) {
//            vv[j] = vv[j - 1] * v[j];
//            ans = max(vv[j], ans);
//        }
//    }
    double curr = v[0];
    for (int i = 1; i < N; i++) {
        curr = v[i] > curr * v[i] ? v[i] : curr * v[i];
        ans = max(curr, ans);
    }
    printf("%.3lf", ans);
}

int main() {
    input();
}