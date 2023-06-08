#include <iostream>
using namespace std;
const int MAX_N = 1e6+4;
long long N, M,L=0,R=1e9,ans;
int a[MAX_N];
void input() {
    ios::sync_with_stdio(0);
    cin.tie(0),cout.tie(0);
    cin >> N >> M;
    for(int i=0; i<N; i++) {
        cin >> a[i];
    }
}

bool check(int mid) {
    long long sum = 0;
    for(int i=0; i<N; i++) {
        if(mid > a[i]) continue;
        sum += a[i]-mid;
    }
    return sum<M;
}


void solve() {
    while(L<=R) {
        long long mid = (L+R)>>1;
        if(check(mid)) {
            R = mid-1;
        } else{
            ans = mid;
            L = mid+1;
        };
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    solve();
    output();
}