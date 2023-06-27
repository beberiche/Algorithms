#include<iostream>
using namespace std;
int N, M, a[404][404], INF = 987654321;
void input(){
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M;
    int st,ed,dist;

    for(int i=0; i<M; i++) {
        cin >> st >> ed >> dist;
        a[st][ed] = dist;
    }
}

void solve() {
    for(int k=1; k<=N; k++) {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(a[i][k] && a[k][j]) {
                    a[i][j] = a[i][j] == 0 ? a[i][k]+a[k][j] : min(a[i][j],a[i][k]+a[k][j]);
                }
            }
        }
    }
}

void output() {
    int ans = INF;
    for(int i=1; i<=N; i++) {
        if(a[i][i] != 0) {
            ans = min(a[i][i], ans);
        }
    }
    cout << (ans == INF ? -1 : ans);
}
int main() {
    input();
    solve();
    output();
}