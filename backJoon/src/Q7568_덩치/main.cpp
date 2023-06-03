#include <iostream>
#include <vector>
using namespace std;
int N;
int a[55][2];
vector<int> v;
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0),cout.tie(0);

    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> a[i][0] >> a[i][1];
    }
}

void solve() {
    for(int i=0; i<N; i++) {
        int cnt = 0;
        for(int j=0; j<N; j++) {
            if(i==j) continue;
            if(a[i][0]<a[j][0] && a[i][1]<a[j][1]) cnt++;
        }
        v.push_back(cnt+1);
    }
}

void output() {
    for (auto n: v) {
        cout << n << " ";
    }
}

int main() {
    input();
    solve();
    output();
}