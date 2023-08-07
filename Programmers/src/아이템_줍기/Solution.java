package 아이템_줍기;

import java.util.*;
// 맵 생성
// 사각형 범위 모두 +1
// 다음 좌표가 1인 경우, 주변에 0이 하나라도 있으면 갈 수 있음
// 다음 좌표가 2이상인 경우, 대각선 방향으로 0이 하나라도 있으면 갈 수 있음

class Solution {
    static int map[][], LEN = 101;
    private static void create_map(int[][] rt) {
        map = new int[LEN][LEN];
        for(int i=0; i<rt.length; i++) {
            for(int j=rt[i][1]*2; j<=rt[i][3]*2; j++) {
                for(int k=rt[i][0]*2; k<=rt[i][2]*2; k++) {
                    map[j][k]++;
                }
            }
        }
    }

    private static int go(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[LEN][LEN];
        q.add(new int[] {start[0]*2, start[1]*2, 0});
        visited[start[0]*2][start[1]*2]++;
        int[] dr = new int[] {-1,1,0,0};
        int[] dc = new int[] {0,0,-1,1};


        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == end[0]*2 && curr[1] == end[1]*2) return curr[2];

            for(int d=0; d<4; d++) {
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];

                if(nr < 1 || nc < 1 || nr >=LEN || nc >= LEN) continue;
                if(map[nr][nc]==0 || visited[nr][nc]>0) continue;

                if((nr == 1|| nc == 1 || nr == LEN -1 || nc == LEN-1) || (map[nr+1][nc]==0 || map[nr-1][nc] ==0 || map[nr][nc+1]==0 || map[nr][nc-1]==0) || (map[nr+1][nc+1]==0 || map[nr-1][nc-1] ==0 || map[nr-1][nc+1]==0 || map[nr+1][nc-1]==0)) {
                    visited[nr][nc]++;
                    q.add(new int[] {nr,nc,curr[2]+1});
                }
            }
        }
        return 0;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        create_map(rectangle);
        return go(new int[] {characterY, characterX}, new int[] {itemY, itemX})/2;
    }
}