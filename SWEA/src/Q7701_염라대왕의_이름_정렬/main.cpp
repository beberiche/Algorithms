#include <cstring>
#include <iostream>
using namespace std;

// 시간초과
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T = 0;
    int N = 0;

    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        string arr[N];
        for (int i = 0; i < N; i++)
            cin >> arr[i];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i].size() > arr[j].size())
                    swap(arr[i], arr[j]);
                if (arr[i].size() == arr[j].size() && arr[i] > arr[j])
                    swap(arr[i], arr[j]);
            }
        }
        cout << "#" << t << "\n";
        for (int i = 0; i < N; i++) {
            if (arr[i] == arr[i + 1])
                continue;
            cout << arr[i] << "\n";
        }
    }

    return 0;
}