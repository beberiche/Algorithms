#include <iostream>
using namespace std;
int a[104][104], N;
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    cin >> N;
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cin >> a[i][j];
        }
    }
}

void solve() {
    for(int k=0; k<N; k++) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(a[i][k] && a[k][j]) {
                    a[i][j] = 1;
                }
            }
        }
    }
}

void output() {
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            cout << a[i][j] << " ";
        }
        cout << "\n";
    }
}
int main() {
    input();
    solve();
    output();
}