//
// Created by 김종현 on 2023/03/22.
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solve(vector<int> &A, vector<int> &B) {
    int AIdx = 0, BIdx = 0, ans = 0, size = A.size();
    while (BIdx<size) A[AIdx] >= B[BIdx] ? BIdx++ : (AIdx++, BIdx++, ans++);
    return ans;
}

int solution(vector<int> A, vector<int> B) {
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    return solve(A, B);
}

int main() {
//    solution({5, 1, 3, 7}, {2, 2, 6, 8});
    solution({2,2,2,2},{1,1,1,1});
}