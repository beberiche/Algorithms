#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
int N;
vector<int> v;

int main() {
    cin >> N;
    int n = round(N * 0.15);
    int num;

    if (N == 0) {
        cout << 0;
        return 0;
    }


    for (int i = 0; i < N; i++) {
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    double sum = 0;
    for (int i = n; i < N - n; i++) {
        sum += v[i];
    }
    double ans = sum / (N - n - n);
    cout << round(ans);
}