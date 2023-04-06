//
// Created by 김종현 on 2023/04/04.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int N;
int visited[70][70][70];
struct S {
    int a, b, c;
};
vector<vector<int>> v = {{9, 3, 1},
                         {9, 1, 3},
                         {3, 9, 1},
                         {3, 1, 9},
                         {1, 9, 3},
                         {1, 3, 9}};
vector<int> scv;

void input() {
    cin >> N;
    scv = vector<int>(3, 0);
    for (int i = 0; i < N; i++) {
        cin >> scv[i];
    }
}

int bfs() {
    queue<S> q;
    q.push({scv[0], scv[1], scv[2]});
    visited[scv[0]][scv[1]][scv[2]] = 1;
    while (!q.empty()) {
        S curr = q.front();
        q.pop();
        if (visited[0][0][0]) break;
        for (int i = 0; i < 6; i++) {
            int na = (curr.a - v[i][0]) > 0 ? curr.a - v[i][0] : 0;
            int nb = (curr.b - v[i][1]) > 0 ? curr.b - v[i][1] : 0;
            int nc = (curr.c - v[i][2]) > 0 ? curr.c - v[i][2] : 0;
            if (visited[na][nb][nc]) continue;
            visited[na][nb][nc] = visited[curr.a][curr.b][curr.c] + 1;
            q.push({na, nb, nc});
        }
    }
    return visited[0][0][0] - 1;
}


void output() {
    cout << bfs();
}

int main() {
    input();
    output();
}