#include <string>
#include <vector>
using namespace std;
const int DIV = 1e9+7;
int solution(int n, vector<int> money) {
    vector<int> v(n+1,0);
    for(int i=0; i<money.size(); i++) {
        v[money[i]]++;
        for(int j=money[i]+1; j<=n; j++) {
            v[j]+=v[j-money[i]]%DIV;
        }
    }
    return v[n] % DIV;
}