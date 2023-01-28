#include <iostream>
using namespace std;
int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    while (scanf("%d", &N) != EOF) {
        int num = 1;
        int mod = num % N;
        int sum = mod;
        int cnt = 1;
        if (mod == 0) {
            cout << cnt << "\n";
            return 0;
        }
        while (1) {
            cnt++;
            mod = mod * 10 % N;
            sum += mod;
            if (!(sum % N))
                break;
        }
        cout << cnt << "\n";
    }
}
