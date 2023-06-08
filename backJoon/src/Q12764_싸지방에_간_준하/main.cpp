#include <iostream>
#include <queue>
#include <vector>

#define f first
#define s second
using namespace std;
const int MAX = 1e6 + 4;
int N, ans = 1, cnt[MAX];
priority_queue<pair<int, int>> pq_f;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq_s;
priority_queue<int> pq_t;

void input() {
    ios::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    cin >> N;
    int a, b;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        pq_f.push({-a, -b});
    }
}

void go() {
    // <끝나는 시간, <시작하는 시간, 인덱스>
    pair<int, int> init = pq_f.top();
    pq_f.pop();
    pq_s.push({-init.s, ans});
    cnt[ans]++;
    while (!pq_f.empty()) {
        pair<int, int> curr = pq_f.top();
        pq_f.pop();

        while (!pq_s.empty() && pq_s.top().f < -curr.f) {
            pq_t.push(-pq_s.top().s);
            pq_s.pop();
        }

        if (!pq_t.empty() > 0) {
            pq_s.push({-curr.s, -pq_t.top()});
            cnt[-pq_t.top()]++;
            pq_t.pop();
        } else {
            cnt[++ans]++;
            pq_s.push({-curr.s, ans});
        }
    }
}

void output() {
    cout << ans << "\n";
    for (int i = 1; i <= ans; i++) {
        cout << cnt[i] << " ";
    }
}

int main() {
    input();
    go();
    output();
}