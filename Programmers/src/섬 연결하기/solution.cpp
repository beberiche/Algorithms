#include <vector>
#include <queue>
#define f first
#define s second
using namespace std;
vector<pair<int,int>> v[104];
int visited[104];
void input(int n, vector<vector<int>> costs) {
    for(int i=0; i<costs.size(); i++) {
        int st = costs[i][0];
        int ed = costs[i][1];
        int dist = costs[i][2];
        v[st].push_back({dist,ed});
        v[ed].push_back({dist,st});
    }
}

int solve(int n) {
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    pq.push({0,0});
    int ans = 0, cnt = 0;
    while(cnt != n) {
        pair<int,int> curr = pq.top();
        pq.pop();
        if(!visited[curr.s]) {
            ans += curr.f;
            visited[curr.s]++;
            for(auto next : v[curr.s]) pq.push(next);
            cnt++;
        }
    }
    return ans;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    input(n, costs);
    return solve(n);
}