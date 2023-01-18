#include <bits/stdc++.h>

using namespace std;
vector<vector<int>> vect{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
vector<int> v2;
int tmp, dr[2] = {-1, -1}, dc[2] = {0, -1};
int solution(vector<vector<int>> triangle) {
    int answer = 0;

    for (int i = 1; i < triangle.size(); i++) {
        for (int j = 0; j <= i; j++) {
            tmp = triangle[i][j];
            for (int d = 0; d < 2; d++) {
                int nr = i + dr[d];
                int nc = j + dc[d];
                if (nr < 0 || nc < 0 || nc >= i)
                    continue;
                triangle[i][j] = max(tmp + triangle[nr][nc], triangle[i][j]);
                answer = max(triangle[i][j], answer);
            }
        }
    }
    return answer;
}
int main() {
    cout << solution(vect);
    return 0;
}
