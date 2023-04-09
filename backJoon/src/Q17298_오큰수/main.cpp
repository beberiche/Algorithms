//
// Created by 김종현 on 2023/03/29.
//
#include <iostream>
#include <stack>
using namespace std;
int N, arr[1000000];
stack<int> st1, st2;
void input() {
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> arr[i];
    }
}

void solve() {
    st1.push(arr[N-1]);
    st2.push(-1);
    for(int i=N-2; i>=0; i--) {
        while(!st1.empty()) {
            if(st1.top() <= arr[i]) {
                st1.pop();
                continue;
            }
            st2.push(st1.top());
            st1.push(arr[i]);
            break;
        }

        if(st1.empty()) {
            st2.push(-1);
            st1.push(arr[i]);
        }
    }
}

void output() {
    while(!st2.empty()) {
        cout << st2.top() << " ";
        st2.pop();
    }
}
int main() {
    input();
    solve();
    output();
}