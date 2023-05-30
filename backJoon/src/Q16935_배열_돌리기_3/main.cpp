#include <iostream>
using namespace std;
int a[104][104], tmp[104][104], N, M, R;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N >> M >> R;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
        }
    }
}

void copyMap() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            a[i][j] = tmp[i][j];
        }
    }
}

void solve1() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tmp[i][j] = a[N - i - 1][j];
        }
    }
    copyMap();
}

void solve2() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tmp[i][j] = a[i][M - j - 1];
        }
    }
    copyMap();
}

void solve3() {
    swap(N, M);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tmp[i][j] = a[M - j - 1][i];
        }
    }
    copyMap();
}

void solve4() {
    swap(N, M);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            tmp[i][j] = a[j][N - i - 1];
        }
    }
    copyMap();
}

void solve5() {
    for (int i = 0; i < N / 2; i++) {
        for (int j = 0; j < M / 2; j++) {
            tmp[i][j] = a[i+N/2][j];
        }
        for (int j = 0; j < M / 2; j++) {
            tmp[i][j+M/2] = a[i][j];
        }
    }

    for(int i=N/2; i<N; i++) {
        for(int j=M/2; j<M; j++) {
            tmp[i][j-M/2] = a[i][j];
        }
        for(int j=M/2; j<M; j++) {
            tmp[i][j] = a[i-N/2][j];
        }
    }
    copyMap();
}

void solve6() {
    for(int i=0; i<N/2; i++) {
        for(int j=0; j<M/2; j++) {
            tmp[i][j] = a[i][j+M/2];
        }
        for(int j=0; j<M/2; j++) {
            tmp[i][j+M/2] = a[i+N/2][j+M/2];
        }
    }

    for(int i=N/2; i<N; i++) {
        for(int j=M/2; j<M; j++) {
            tmp[i][j-M/2] = a[i-N/2][j-M/2];
        }
        for(int j=M/2; j<M; j++) {
            tmp[i][j] = a[i][j-M/2];
        }
    }
    copyMap();
}

void go() {
    int num;
    for (int i = 0; i < R; i++) {
        cin >> num;
        switch (num) {
            case 1 :
                solve1();
                break;
            case 2 :
                solve2();
                break;
            case 3 :
                solve3();
                break;
            case 4 :
                solve4();
                break;
            case 5 :
                solve5();
                break;
            case 6 :
                solve6();
                break;
        }
    }
}

void output() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cout << a[i][j] << " ";
        }
        cout << "\n";
    }
}

int main() {
    input();
    go();
    output();
}