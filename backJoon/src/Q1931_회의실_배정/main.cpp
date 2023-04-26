//
// Created by 김종현 on 2023/04/26.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;

bool cmp(pair<int,int> p1, pair<int,int> p2) {
    if(p1.second == p2.second) return p1.first < p2.first;
    return p1.second < p2.second;
}
int main() {
    ios::sync_with_stdio(0),cin.tie(0), cout.tie(0);
    cin >> N;
    vector<pair<int,int>> v(N);
    for(int i=0; i<N; i++) {
        cin >> v[i].first >> v[i].second;
    }

    sort(v.begin(),v.end(),cmp);
    int curr = v[0].second,cnt = 1;
    for(int i=1; i<N; i++) {
        if(curr <= v[i].first) {
            cnt++;
            curr = v[i].second;
        }
    }
    cout << cnt;
}