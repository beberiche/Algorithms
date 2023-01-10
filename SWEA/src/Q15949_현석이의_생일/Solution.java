package Q15949_현석이의_생일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String ans = "";
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String N = stk.nextToken();
            String x = stk.nextToken();
            String y = stk.nextToken();
            int nN = Integer.parseInt(N);
            int len = N.length();
            if(nN<Integer.parseInt(x+y)) {
                ans = "-1";
            } else {
                ans = "아님";
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
