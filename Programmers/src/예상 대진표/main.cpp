//
// Created by 김종현 on 2023/04/16.
//
#include <iostream>
using namespace std;
int ans;

int go(int n) {
    if(n==1) return 0;
    return 1 + go(n/2);
}

void solve(int len, int l, int r, int a, int b) {
    int mid = (l+r) >> 1;
    if(l>=r || len <= 0) return;
    if(a <= mid &&  b > mid) {
        ans = len;
        return;
    };
    if(a<=mid && b<=mid) solve(len-1, l, mid, a, b);
    if(a > mid && b > mid) solve(len-1, mid+1, r,a,b);
}

int solution(int n, int a, int b)
{
    int answer;
    int len = go(n);
    int min = a < b ? a : b;
    int max = a < b ? b : a;
    solve(len, 1, n,min,max);
    return ans;
}