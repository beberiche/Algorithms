#include <iostream>
#include <deque>
using namespace std;
deque<int> dq;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    int N;
    cin >> N;
    string cmd;
    int num;
    while(N--) {
        cin >> cmd;
        if(cmd=="push_back") {
            cin >> num;
            dq.push_back(num);
        } else if (cmd == "push_front") {
            cin >> num;
            dq.push_front(num);
        } else if (cmd == "front") {
            cout << (dq.empty() ? -1 : dq.front()) << "\n";
        } else if (cmd == "back") {
            cout << (dq.empty() ? -1 : dq.back()) << "\n";
        } else if(cmd == "size") {
            cout << dq.size() << "\n";
        } else if(cmd == "empty") {
            cout << (dq.empty() ? 1 : 0) << "\n";
        } else if(cmd == "pop_front") {
            if(dq.empty()) {
                cout << -1 << "\n";
            } else {
                cout << dq.front() << "\n";
                dq.pop_front();
            }
        } else if(cmd == "pop_back") {
            if(dq.empty()) {
                cout << -1 << "\n";
            } else {
                cout << dq.back() << "\n";
                dq.pop_back();
            }
        }
    }
}