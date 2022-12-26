package Q15661_링크와_스타트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int N, K;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 987654321;
        for(int i=2; i<=N/2; i++) {
            comb(0,0,i);
        }
        System.out.println(ans);
    }

    private static void comb(int idx, int cnt, int K) {
        if (cnt >= K) {
            sum();
            return;
        }

        for(int i=idx; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            comb(i+1, cnt+1, K);
            visited[i] = false;
        }
    }

    private static void sum() {
        int teamA = 0;
        int teamB = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] && visited[j]) teamA += map[i][j] + map[j][i];
                else if(!visited[i] && !visited[j]) teamB += map[i][j] + map[j][i];
            }
        }

        int diff = Math.abs(teamA - teamB);
        if(diff == 0) {
            System.out.println(0);
            System.exit(0);
        }
        ans = Math.min(diff, ans);
    }
}
