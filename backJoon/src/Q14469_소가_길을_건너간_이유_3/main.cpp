//
// Created by 김종현 on 2023/04/26.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N;
int main() {
    cin >> N;
    vector<pair<int,int>> v(N);
    for (int i = 0; i < N; i++) {
        cin >> v[i].first >> v[i].second;
    }
    sort(v.begin(), v.end());
    int curr = v[0].first + v[0].second;
    for(int i=1; i<v.size(); i++) {
        curr = max(curr, v[i].first)+v[i].second;
    }
    cout << curr;
}