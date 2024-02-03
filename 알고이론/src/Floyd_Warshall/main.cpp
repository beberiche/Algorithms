#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int number =4;
    int INF = 987654321;

    int a [4][4] = {
            {0,5,INF, 8},
            {7,0,9,INF},
            {2,INF,0,4},
            {INF,INF,3,8}
    };

    int d[number][number];

    for(int i=0; i<number;i++) {
        for(int j=0; j<number;j++) {
            d[i][j] = a[i][j];
        }
    }

    // k는 거처가는 노드
    // i에서 j로 바로 가는 값과 i-> k -> j로 돌아가는 값을 비교했을 때 더 작은 값을 업데이트
    for(int k=0; k<number; k++) {
        for(int i=0; i<number; i++) {
            for(int j=0; j<number; j++) {
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }

    for(int i=0; i<number; i++) {
        for(int j=0; j<number; j++) {
            cout << d[i][j] << " ";
        }
        cout << "\n";
    }
}

