//
// Created by 김종현 on 2023/03/29.
//
#include <iostream>
using namespace std;
double x,y;
long long ans,z;
void input() {
    ios::sync_with_stdio(0), cin.tie(0);
    cin >> x >> y;
    z = y*100/x;
}

long long check(long long mid) {
    return (y+mid)*100/(x+mid);
}

void solve() {
    long long l=0;
    long long r=x;
    while(l<r) {
        long long mid = (l+r)/2;
        if(z < check(mid)) r = mid;
        else l = mid+1;
    }
    ans = l;
}

void output() {
    cout << (ans == x ? -1 : ans);
}

int main() {
    input();
    if(z>=99) {
        cout << -1;
        return 0;
    }
    solve();
    output();
}

