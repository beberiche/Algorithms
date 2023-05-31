#include <iostream>
using namespace std;
int N;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0),cout.tie(0);
    cin >> N;
    int ans = 0, num = 0;
    string str;
    while (N--) {
        cin >> str;
        if (str == "add") {
            cin >> num;
            ans |= (1 << num);
        } else if (str == "check") {
            cin >> num;
            if (ans & (1 << num)) cout << 1 << "\n";
            else cout << 0 << "\n";
        } else if (str == "remove") {
            cin >> num;
            ans &= ~(1 << num);
        } else if (str == "toggle") {
            cin >> num;
            if (ans & (1 << num)) {
                ans &= ~(1 << num);
            } else {
                ans |= (1 << num);
            }
        } else if(str == "all") {
            ans = (1<<21) - 1;
        } else if(str == "empty") {
            ans = 0;
        }
    }
}