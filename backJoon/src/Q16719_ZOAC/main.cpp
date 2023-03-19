//
// Created by 김종현 on 2023/03/19.
//
#include <iostream>
using namespace std;
string str;
bool visited[100];
void solve(int st, int ed) {
    if(st>ed) return;

    int minIdx = ed+1;
    char minChar = 'Z'+1;
    for(int i=st; i<=ed; i++) {
        if(minChar > str[i]) {
            minChar = str[i];
            minIdx = i;
        }
    }
    visited[minIdx] = true;
    string tmp = "";
    for(int i=0; i<str.length(); i++)
        if(visited[i]) tmp += str[i];

    cout << tmp << "\n";
    solve(minIdx+1, ed);
    solve(st,minIdx-1);
}
int main() {
    cin >> str;
    solve(0, str.length()-1);
}