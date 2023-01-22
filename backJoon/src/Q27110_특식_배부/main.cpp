#include <bits/stdc++.h>
using namespace std;
int N, A, B, C;
int main() {
    cin >> N >> A >> B >> C;
    cout << min(N, A) + min(N, B) + min(N, C);
}