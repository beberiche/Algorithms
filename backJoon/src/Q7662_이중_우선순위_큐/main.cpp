#include <iostream>
#include <queue>
#include <vector>
#define f first
#define s second
using namespace std;
int T, N;
priority_queue<pair<int, int>> maxQ;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minQ;
const int MAX = 1e6 + 4;

void updateHeap(int check[MAX]) {
    while (!maxQ.empty() && !check[maxQ.top().s]) maxQ.pop();
    while (!minQ.empty() && !check[minQ.top().s]) minQ.pop();
}

void go() {
    cin >> N;
    maxQ = priority_queue<pair<int, int>>();
    minQ = priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>();
    int check[MAX];
    char op;
    int num;
    for (int i = 0; i < N; i++) {
        cin >> op >> num;
        if (op == 'I') {
            maxQ.push({num, i});
            minQ.push({num, i});
            check[i]++;
        } else {
            if (num == 1 && !maxQ.empty()) {
                check[maxQ.top().s]--;
                maxQ.pop();
            } else if (num == -1 && !minQ.empty()) {
                check[minQ.top().s]--;
                minQ.pop();
            }
            updateHeap(check);
        }
    }
}

void output() {
    if (maxQ.empty()) cout << "EMPTY" << "\n";
    else cout << maxQ.top().f << " " << minQ.top().f << "\n";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    while (T--) {
        go();
        output();
    }
}