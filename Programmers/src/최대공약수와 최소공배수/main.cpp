#include <string>
#include <vector>

using namespace std;
int GCD(int n, int m) { return m ? GCD(m, n % m) : n; }

vector<int> solution(int n, int m) {
    vector<int> answer;
    answer.push_back(n < m ? GCD(m, n) : GCD(n, m));
    answer.push_back(n * m / answer[0]);
    return answer;
}