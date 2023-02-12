#include <iostream>
using namespace std;
string str;

void input() { cin >> str; }

bool is_idx_P(int idx) { return str[idx] == 'P'; }

bool solve() {
    int p_cnt = 0;
    for (int i = 0; i < str.size(); i++) {
        if (is_idx_P(i))
            p_cnt++;
        else if (p_cnt >= 2 && i + 1 < str.size() && is_idx_P(i + 1)) {
            p_cnt -= 2;
        } else {
            return false;
        }
    }
    if (p_cnt == 1)
        return true;
    else
        return false;
}

void output() { cout << (solve() ? "PPAP" : "NP"); }

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    output();
    return 0;
}