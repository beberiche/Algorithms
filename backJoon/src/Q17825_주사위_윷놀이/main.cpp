//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <vector>
using namespace std;
// dice, player, score
int d[10], p[4], s[33], ans;
vector<int> adj[33];

void input() {
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    for (int i = 0; i < 10; i++) cin >> d[i];
}

int go(int idx, int cnt) {
    if (idx == 32) return 32;
    if (idx % 5 == 0 && idx > 0 && idx <= 15) {
        idx = adj[idx][1];
        cnt--;
    }
    if (!cnt) return idx;
    else {
        int curr = adj[idx][0];
        int next;
        while (--cnt) {
            if (curr == 32) break;
            next = adj[curr][0];
            curr = next;
        }
        return curr;
    }
}

bool check(int next, int idx) {
    if (next == 32) return false;
    for (int i = 0; i < 4; i++) {
        if (i == idx) continue;
        if (next == p[i]) return true;
    }
    return false;
}


void solve(int idx, int sum) {
    if (idx == 10) {
        ans = max(ans, sum);
        return;
    }
    for (int i = 0; i < 4; i++) {
        int curr = p[i];
        int next = go(curr, d[idx]);
        if (check(next, i)) continue;
        p[i] = next;
        solve(idx + 1, sum + s[next]);
        p[i] = curr;
    }
}

void map() {
    // 출발 -> 40
    for (int i = 0; i < 20; i++) adj[i].push_back(i + 1);
    for (int i = 1; i <= 20; i++) s[i] = i * 2;
    // 10 -> 25
    adj[5].push_back(21); s[21] = 13;
    adj[21].push_back(22); s[22] = 16;
    adj[22].push_back(23); s[23] = 19;
    adj[23].push_back(24); s[24] = 25;
    // 20 -> 25
    adj[10].push_back(25);
    s[25] = 22; adj[25].push_back(26);
    s[26] = 24; adj[26].push_back(24);
    // 30 -> 25
    adj[15].push_back(27);
    s[27] = 28; adj[27].push_back(28);
    s[28] = 27; adj[28].push_back(29);
    s[29] = 26; adj[29].push_back(24);
    // 25 -> 40
    adj[24].push_back(30); s[30] = 30;
    adj[30].push_back(31); s[31] = 35;
    adj[31].push_back(20);
    // 도착
    adj[20].push_back(32);
}

void output() {
    cout << ans;
}

int main() {
    input();
    map();
    solve(0, 0);
    output();
}