//
// Created by 김종현 on 2023/04/29.
//
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
int N, ans;
vector<int> pv;
bool visited[4000000 + 4];

void input() {
    cin >> N;
}

// N까지의 소수를 구해 누적합 만들기
void goPrimeNums() {
    for (int i = 2; i <= sqrt(N); i++) {
        if (!visited[i]) for (int j = i + i; j <= N; j += i) visited[j] = true;
    }

    for (int i = 2; i <= N; i++) {
        if(!visited[i]) pv.push_back(i);
    }
}

void findN() {
    int sum = 0, l = 0, r = 0;
    while (true) {
        if (sum >= N) sum -= pv[l++];
        else if(r >= pv.size()) break;
        else sum += pv[r++];
        if (sum == N) ans++;
    }
}

void output() {
    cout << ans;
}

int main() {
    input();
    goPrimeNums();
    findN();
    output();
}