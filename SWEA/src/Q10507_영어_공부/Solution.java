package Q10507_영어_공부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N,P,ans;
    static boolean[] visited;
    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        P = Integer.parseInt(stk.nextToken());
        visited = new boolean[1000004];
        stk = new StringTokenizer(br.readLine());
        ans = P+1;
        for(int i=0; i<N; i++) {
            visited[Integer.parseInt(stk.nextToken())] = true;
        }
    }

    private static void solve() {
        int l = 1;
        int r = 1;
        int cnt = 0;
        while(r<visited.length) {
            if(visited[r]) {
                r++;
                ans = Math.max(++cnt, ans);
            } else {
                if(P<=0) {
                    ans = Math.max(cnt--, ans);
                    if(!visited[l++]) P++;
                } else {
                    P--;
                    cnt++;
                    r++;
                }
            }
        }
    }

    private static void output(int t) {
        sb.append("#").append(t).append(" ").append(ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            input();
            solve();
            output(t);
        }
        System.out.print(sb);
    }
}
