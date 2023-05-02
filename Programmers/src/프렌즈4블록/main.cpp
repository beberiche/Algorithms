//
// Created by 김종현 on 2023/05/02.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<pair<int,int>> tmp;
int solution(int m, int n, vector<string> board) {
    int answer = 0;
    // 모두 탐색 현재 인덱스에서 오른쪽, 아래, 대각선 아래 보고 모두 같다면 좌표저장
    while(true) {
        bool check = false;
        tmp.clear();
        for(int i=0; i<board.size(); i++) {
            for(int j=0; j<board[i].size(); j++) {
                if(i+1>=m || j+1>=n) continue;
                if(board[i][j] == '0') continue;
                if(board[i][j] == board[i+1][j] && board[i+1][j] == board[i][j+1] && board[i][j+1] == board[i+1][j+1]) {
                    check = true;
                    tmp.push_back({i,j}), tmp.push_back({i+1,j}), tmp.push_back({i,j+1}), tmp.push_back({i+1,j+1});
                }
            }
        }
        if(!check) break;

        // 탐색 후 저장한 좌표들 비우기
        for(auto p : tmp) {
            if(board[p.first][p.second] == '0') continue;
            board[p.first][p.second] = '0';
            answer++;
        }


        // 아래에서 위로 거꾸로 보면서 빈공간 있으면 한칸씩 내리기
        for(int i=board.size()-2; i>=0; i--) {
            for(int j=0; j<board[i].size(); j++) {
                if(board[i][j] != '0' && board[i+1][j] == '0') {
                    int idx = i+1;
                    while(idx+1<m && board[idx+1][j] == '0') idx++;
                    int t = board[i][j];
                    board[i][j] = board[idx][j];
                    board[idx][j] = t;
                }
            }
        }
    }

    return answer;
}