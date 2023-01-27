#include <iostream>
#define N_MAX 15000
using namespace std;

int N, M, ans, arr[N_MAX + 4];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        cin >> arr[i];

    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; j++)
            arr[i] + arr[j] == M &&ans++;

    cout << ans;
}