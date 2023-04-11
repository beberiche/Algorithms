//
// Created by 김종현 on 2023/04/12.
//
#include <vector>
#include <queue>
#include <algorithm>
#define f first
#define s second
using namespace std;
typedef pair<int, int> pii;

struct cmp {
    bool operator()(pii v1, pii v2) {
        return v1.second > v2.second;
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    sort(jobs.begin(), jobs.end());

    priority_queue<pii, vector<pii>, cmp> pq;
    int len = jobs.size();
    int i = 0, time = 0;

    while (i < len || !pq.empty()) {;
        if (i < len && jobs[i][0] <= time) {
            pq.push({jobs[i][0], jobs[i++][1]});
            continue;
        }

        if (!pq.empty()) {
            time += pq.top().s;
            answer += time - pq.top().f;
            pq.pop();
        }
        else time = jobs[i][0];
    }

    return answer / len;
}