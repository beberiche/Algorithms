#include <bits/stdc++.h>
using namespace std;
int n, m, INF = 987654321;
int arr[101][101];

void print() {
    int ans;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            ans = arr[i][j] == INF ? 0 : arr[i][j];
            cout << ans << " ";
        }
        cout << "\n";
    }
}

void fw() {
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
            }
        }
    }
}

void init() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            arr[i][j] = i == j ? 0 : INF;
        }
    }

    int st, ed, v;
    for (int i = 0; i < m; i++) {
        cin >> st >> ed >> v;
        arr[st][ed] = min(arr[st][ed], v);
    }
}

int main() {
    init();
    fw();
    print();
    return 0;
}