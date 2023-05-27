#include <string>
#include <vector>
using namespace std;
int cnt = 0;
bool go(int k, int mid, vector<int> &stones) {
    cnt = 0;
    for(int s : stones) {
        cnt += s-mid<=0 ? 1 : -cnt;
        if(cnt >= k) break;
    }
    return cnt >= k;
}

int solution(vector<int> stones, int k) {
    int l = 1, r = 2e8;
    int mid, ans;
    while(l<=r) {
        mid = (l+r)>>1;
        if(go(k,mid,stones)) {
            ans = mid;
            r = mid -1;
        } else l = mid +1;
    }
    return ans;
}