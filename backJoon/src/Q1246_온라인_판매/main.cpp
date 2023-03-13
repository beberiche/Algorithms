#include <iostream>
#include <algorithm>
using namespace std;
int N, M, arr[1004];
int main() {
    cin >> N >> M;
    for(int i=0; i<M; i++) {
        cin >> arr[i];
    }
    sort(arr, arr+M);
    int result = arr[0]*M, idx = arr[0];
    for(int i=M-N; i<M; i++) {
        int curr_v = arr[i]*(M-i);
        if(result < curr_v) {
            idx = arr[i];
            result = curr_v;
        }
    }
    cout << idx << " " << result;
}