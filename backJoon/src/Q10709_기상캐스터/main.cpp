//
// Created by 김종현 on 2023/02/23.
//
#include <iostream>
using namespace std;
int N,M,arr[100][100];
void input() {
    cin >> N >> M;
    string str;
    for(int i=0; i<N; i++) {
        cin >> str;
        for(int j=0; j<M; j++) {
            arr[i][j] = str[j] == 'c' ? 0 : -1;
        }
    }
}

void solve() {
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            if(arr[i][j] != -1) {
                for(int d=j+1; d<M; d++) {
                    if(arr[i][d] == -1) arr[i][d] = arr[i][d-1]+1;
                    else break;
                }
            }
        }
    }
}

void output() {
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
}

int main() {
    input();
    solve();
    output();
}