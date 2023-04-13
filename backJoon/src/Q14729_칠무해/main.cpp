//
// Created by 김종현 on 2023/04/12.
//
#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    double num;
    priority_queue<double> pq;
    for (int i = 0; i < N; i++) {
        cin >> num;
        pq.push(num * (double) -1);
    };
    int cnt = 7;
    cout << fixed;
    cout.precision(3);
    while (cnt--) {
        cout << pq.top() * (double) -1 << "\n";
        pq.pop();
    }
}