#include <iostream>
using namespace std;
int N, M, st, ed, cnt;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> cnt;
    st = 1;
    ed = M;

    int curr = 1;
    int next;
    int ans = 0;

    while (--cnt >= 0) {
        cin >> next;
        if (curr < next) {
            if (st <= next && next <= ed)
                continue;
            else
                ans += next - ed;
            ed = next;
            st = ed - M + 1;
        } else if (curr == next) {
            continue;
        } else {
            if (st <= next && next <= ed)
                continue;
            else
                ans += st - next;
            st = next;
            ed = st + M - 1;
        }
        curr = next;
    }
    cout << ans;

    return 0;
}