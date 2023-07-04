#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    int N, M;
    unordered_map<string, string> m;
    cin >> N >> M;
    string a,b;
    for(int i=0; i<N; i++) {
        cin >> a >> b;
        m[a] = b;
    }

    for(int i=0; i<M; i++) {
        cin >> a;
        cout << m[a] << "\n";
    }
}