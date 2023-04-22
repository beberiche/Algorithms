//
// Created by 김종현 on 2023/04/22.
//
#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int N, len;
vector<int> v;
vector<pair<int, int>> vp;
stack<int> s;
void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> N;
    int num;
    cin >> num;
    v.push_back(num);
    vp.push_back({0, num});
    for (int i = 1; i < N; i++) {
        cin >> num;
        if (v.back() < num) {
            v.push_back(num);
            vp.push_back({v.size()-1, num});
            continue;
        }
        int l = 0;
        int r = v.size() - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (v[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        v[r] = num;
        vp.push_back({r, num});
    }
    len = v.size();
}

void solve() {
    for(int i=vp.size()-1; i>=0; i--) {
        if(len-1==vp[i].first) {
            s.push(vp[i].second);
            len--;
        }
    }
}

void output() {
    cout << v.size() << "\n";
    while(!s.empty()) {
        cout << s.top() << " ";
        s.pop();
    }
}

int main() {
    input();
    solve();
    output();
}