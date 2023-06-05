#include <string>
#include <vector>
using namespace std;
int a[104][104];
const int INF = 1e9 + 7;
int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;

    for(int i=0; i<puddles.size(); i++) {
        a[puddles[i][1]][puddles[i][0]]=-1;
    }

    a[1][1] = 1;
    for(int i=2; i<=n; i++) {
        a[i][1] = a[i][1] == -1 ? a[i][1] : a[i-1][1];
    }
    for(int j=2; j<=m; j++) {
        a[1][j] = a[1][j] == -1 ? a[1][j] : a[1][j-1];
    }


    for(int i=2; i<=n; i++) {
        for(int j=2; j<=m; j++) {
            if(a[i][j]==-1) continue;
            int r = a[i-1][j] == -1 ? 0 : a[i-1][j];
            int c = a[i][j-1] == -1 ? 0 : a[i][j-1] ;
            a[i][j]=(r+c)%INF;
        }
    }

    return a[n][m]%INF;
}