package Q0829_전원연결;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int ans;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];

            ans = 987654321;
            List<int[]> raxiPos = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    // r값 c값
                    if ((i==0 || j==0) && map[i][j] == 1) map[i][j] = 2;
                    else if (map[i][j] == 1) raxiPos.add(new int[]{i, j});
                }
            }

            visited = new boolean[N][N];
            recur(raxiPos, 0, 0, true);
            if(ans == 987654321) recur(raxiPos,0,0,false);
            System.out.printf("#%d %d\n", tc,ans);
        }
    }

    public static void recur(List<int[]> raxiPos, int idx, int dist, boolean all) {
        if(idx >= raxiPos.size()) {
            ans = Math.min(ans, dist);
            return;
        }


        boolean allCheck = false;
        for (int d = 0; d < 4; d++) {
            int[] currRaxi = raxiPos.get(idx);
            if (d == 0) {
                boolean check = true;
                for(int c=currRaxi[1]+1; c<N; c++) {
                    if(map[currRaxi[0]][c]!=0 || visited[currRaxi[0]][c]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    allCheck = true;
                    for(int c=currRaxi[1]+1; c<N; c++) visited[currRaxi[0]][c] = true;
                    recur(raxiPos, idx+1,  dist+N-currRaxi[1]-1,all);
                    for(int c=currRaxi[1]+1; c<N; c++) visited[currRaxi[0]][c] = false;
                }
            } else if (d == 1) {
                boolean check = true;
                for(int r=currRaxi[0]+1; r<N; r++) {
                    if(map[r][currRaxi[1]]!=0 || visited[r][currRaxi[1]]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    allCheck = true;
                    for(int r=currRaxi[0]+1; r<N; r++) visited[r][currRaxi[1]] = true;
                    recur(raxiPos, idx+1, dist+N-currRaxi[0]-1, all);
                    for(int r=currRaxi[0]+1; r<N; r++) visited[r][currRaxi[1]] = false;
                }
            } else if (d == 2) {
                boolean check = true;
                for(int c=0; c<currRaxi[1]; c++) {
                    if(map[currRaxi[0]][c] !=0 || visited[currRaxi[0]][c]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    allCheck = true;
                    for(int c=0; c<currRaxi[1]; c++) visited[currRaxi[0]][c] = true;
                    recur(raxiPos, idx+1,  dist+currRaxi[1],all);
                    for(int c=0; c<currRaxi[1]; c++) visited[currRaxi[0]][c] = false;
                }
            } else {
                boolean check = true;
                for(int r=0; r<currRaxi[0]; r++) {
                    if(map[r][currRaxi[1]] !=0 || visited[r][currRaxi[1]]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    allCheck = true;
                    for(int r=0; r<currRaxi[0]; r++) visited[r][currRaxi[1]] = true;
                    recur(raxiPos, idx+1, dist+currRaxi[0],all);
                    for(int r=0; r<currRaxi[0]; r++) visited[r][currRaxi[1]] = false;
                }
            }
        }

        // 어디를 연결해도 안되는 애
        if(!allCheck && !all) recur(raxiPos, idx+1, dist, all);
    }
}
