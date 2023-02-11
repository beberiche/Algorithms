package Q1461_프로세서_연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static List<int[]> coreList;
    static int ans, maxCnt, N;
    static final int[] dr = {-1,0,1,0};
    static final int[] dc = {0,-1,0,1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        coreList = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i ==0 || j==0 || i==N-1 || j==N-1) continue;
                if(map[i][j] == 1) coreList.add(new int[]{i,j});
            }
        }
        ans = 0;
        maxCnt = 0;
    }

    private static void dfs(int idx, int length, int cnt, int[][] copy) {
        if (idx == coreList.size()) {
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans = length;
            }
            else if (cnt == maxCnt) {
                ans = Math.min(ans, length);
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = coreList.get(idx)[0] + dr[d];
            int nc = coreList.get(idx)[1] + dc[d];

            while (nr >= 0 && nr < N && nc >= 0 && nc < N && copy[nr][nc] == 0) {
                if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
                    nr = coreList.get(idx)[0] + dr[d];
                    nc = coreList.get(idx)[1] + dc[d];
                    int wireLen = 0;
                    int[][] temp = copyMap(copy);

                    while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        temp[nr][nc] = 2;
                        wireLen++;

                        nr += dr[d];
                        nc += dc[d];
                    }

                    dfs(idx+1, length+wireLen, cnt+1, temp);
                    break;
                }
                nr += dr[d];
                nc += dc[d];
            }
        }

        dfs(idx+1, length, cnt, copy);
    }
    private static void output(int t) {
        System.out.println("#"+t+" "+ans);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copyMap = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            input();
            dfs(0,0,0,copyMap(map));
            output(t);
        }
    }
}
