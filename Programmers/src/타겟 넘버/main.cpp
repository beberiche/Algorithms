//
// Created by 김종현 on 2023/04/22.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<int> v;
int dfs(vector<int> &n, int t, int sum, int i) {
    if(i >= n.size()) {
        return (sum==t ? 1 : 0);
    }
    int ans = 0;
    ans += dfs(n, t, sum+n[i], i+1) + dfs(n, t, sum-n[i], i+1);
    return ans;
}

int solution(vector<int> numbers, int target) {
    return dfs(numbers,target,0, 0);
}