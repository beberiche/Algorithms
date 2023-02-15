package Q1722_순열의_순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, k;
    static long[] ftrl;
    static boolean[] visited;
    static int[] cmp;
    static long idx;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        ftrl = new long[N+1];
        visited = new boolean[N+1];
        ftrl[0] = 1;
        for (int i = 1; i <= N; i++) {
            ftrl[i] = ftrl[i-1]*i;
        }
    }

    private static void solve() {
        cmp = new int[N+1];
        if (k == 1) {
            idx = Long.parseLong(stk.nextToken());
            solve_one();
        } else {
            for(int i=1; i<=N; i++) {
                cmp[i] = Integer.parseInt(stk.nextToken());
            }
            solve_two();
        }
    }

    private static void solve_one() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(visited[j]) continue;
                if(ftrl[N-i]<idx) {
                    idx-=ftrl[N-i];
                } else {
                    cmp[i]=j;
                    visited[j]= true;
                    break;
                }
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(cmp[i]+" ");
        }
    }

    private static void solve_two() {
        idx = 1;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<cmp[i]; j++) {
                if(visited[j]) continue;
                idx+=ftrl[N-i];
            }
            visited[cmp[i]]= true;
        }
        System.out.println(idx);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
}
