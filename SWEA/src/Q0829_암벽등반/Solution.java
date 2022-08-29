package Q0829_암벽등반;

import java.util.Scanner;

public class Solution {
    static int ans;
    static int N, M;
    static int[] stPos, edPos;
    static int[][] map;
    static final int[] DR = new int[] {-1,0,1,0};
    static final int[] DC = new int[] {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            // 높이
            N = sc.nextInt();
            // 너비
            M = sc.nextInt();

            ans = 987654321;
            map = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 2) stPos = new int[] {i,j};
                    else if(map[i][j] == 3) edPos = new int[] {i,j};
                }
            }
            boolean[][] visited = new boolean[N][M];
            visited[stPos[0]][stPos[1]] = true;
            DFS(stPos[0], stPos[1], 1, visited);
        }
    }

    public static void DFS(int r, int c, int lv, boolean[][] visited) {
       if(ans < lv) return;
       if(r== edPos[0] && c == edPos[1])
           ans = lv;

       for(int d=0; d<4; d++) {
           int nr = r + DR[d];
           int nc = c + DC[d];

          if(nr < 0 || nc < 0 || nr >=N || nc >=M) continue;
          if(visited[nr][nc]) continue;

          if(map[nr][nc]==0&& d%2==0) {
              // 점프하는 경우 -> lv이 올라감

          } else if(map[nr][nc]==1){
              // 옆에 난간 혹은 골 -> lv 그대로
          }
       }
    }
}
