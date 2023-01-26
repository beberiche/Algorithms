package Q1249_보급로;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution2 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                String str = br.readLine();
                for(int j=0; j<N; j++) map[i][j] = str.charAt(j)-'0';
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)->n1[2]-n2[2]);
            pq.add(new int[] {0,0,0});
            visited[0][0] = true;

            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                if(curr[0] == N-1 && curr[1] == N-1) {
                    sb.append(curr[2]).append("\n");
                    break;
                }
                for(int d=0; d<4; d++) {
                    int nr = curr[0] +dr[d];
                    int nc = curr[1] +dc[d];

                    if(nr < 0 || nc < 0 || nr >= N || nc>=N) continue;
                    if(visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    pq.add(new int[] {nr,nc, curr[2]+map[nr][nc]});
                }
            }
        }
        System.out.print(sb);
    }
}
