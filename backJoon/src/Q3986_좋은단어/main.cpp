#include <iostream>
#include <stack>
using namespace std;
int N, ans;
string str;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> str;
        stack<char> s;
        s.push(str[0]);
        for (int j = 1; j < str.size(); j++)
            s.size() ? s.top() == str[j] ? s.pop() : s.push(str[j])
                     : s.push(str[j]);
        !s.size() && ans++;
    };
    cout << ans;
}