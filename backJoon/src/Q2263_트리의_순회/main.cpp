#include <iostream>
using namespace std;
const int MAX = 1e6 + 4;
int io[MAX], po[MAX], N;
void input() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> io[i]; // in order;
    }
    for (int i = 0; i < N; i++) {
        cin >> po[i]; // post order;
    }
}

void dvcq(int is, int ie, int ps, int pe) {
    if (is > ie || ps > pe)
        return;
    cout << po[pe] << ' ';
    int mid = -1;
    for (int i = is; i <= ie; i++) {
        if (io[i] == po[pe]) {
            mid = i;
            break;
        }
    }

    dvcq(is, mid - 1, ps, ps + mid - is - 1);
    dvcq(mid + 1, ie, ps + mid - is, pe - 1);
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    dvcq(0, N - 1, 0, N - 1); // divide & conquer
    return 0;
}