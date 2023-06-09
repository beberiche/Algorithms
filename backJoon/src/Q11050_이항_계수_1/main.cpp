#include <iostream>
using namespace std;
int N, K;
//int go(int n, int k) {
//    if(k == 0 || n == k) return 1;
//    int ans1 = go(n-1,k-1);
//    int ans2 = go(n-1, k);
//    return ans1 + ans2;
//}

int go2(int num) {
    int ret = 1;
    for(int i=2; i<=num; i++) ret*=i;
    return ret;
}


int main() {
    cin >> N >> K;
//    cout << go(N, K);
    cout << go2(N)/(go2(K)*go2(N-K));
}