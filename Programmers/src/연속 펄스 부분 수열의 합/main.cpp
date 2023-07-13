#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(vector<int> sequence) {
    long long answer = 0;
    vector<long long> v;
    v.push_back(sequence[0]);
    int idx = -1;
    long long MIN = sequence[0], MAX = sequence[0];
    for(int i=1; i<sequence.size(); i++) {
        v.push_back(v[i-1] + sequence[i]*idx);
        idx*=-1;
        MIN = min(MIN, v[i]), MAX = max(MAX, v[i]);
    }
    answer = max(answer, max(MAX,-MAX));
    answer = max(answer, max(MIN,-MIN));
    answer = max(answer, MAX-MIN);

    return answer;
}