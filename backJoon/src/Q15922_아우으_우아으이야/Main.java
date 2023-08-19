package Q15922_아우으_우아으이야;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int ans = 0;
        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int currL = Integer.parseInt(stk.nextToken());
            int currR = Integer.parseInt(stk.nextToken());

            if (r < currL) {
                ans += Math.abs(l - r);
                l = currL;
                r = currR;
            } else if (r < currR) {
                r = currR;
            }
        }
        ans += Math.abs(l - r);
        System.out.println(ans);
    }
}
