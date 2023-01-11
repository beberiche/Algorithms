package Q15949_현석이의_생일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static boolean check;
    static int x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringBuilder ans = new StringBuilder();
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String N = stk.nextToken();
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            check = false;

            if (N.length() == 1 && Integer.parseInt(N) < x) {
                printSb(t, new StringBuilder("-1"));
                continue;
            }

            int c = 0;
            while (c < N.length()) {
                char curr = N.charAt(c);
                if (check) ans.append(y);
                else if (curr == y + '0') {
                    ans.append(y);
                } else if (curr == x + '0') {
                    ans.append(x);
                } else if (curr > y + '0') {
                    check = true;
                    ans.append(y);
                } else if (curr > x + '0') {
                    check = true;
                    ans.append(x);
                } else if (curr < x + '0') {
                    int idx = ans.lastIndexOf("" + y);
                    if (idx == -1) {
                        ans = new StringBuilder();
                        c = 0;
                    } else {
                        ans = new StringBuilder(ans.substring(0, idx+1)).replace(idx, idx+1, x+"");
                        c = idx;
                    }
                    check = true;
                } else if ((int) curr > y + '0') {
                    check = true;
                    ans.append(x);
                }
                c++;
            }

            if(ans.length()<=1 && ans.charAt(0) == '0') {
                printSb(t, new StringBuilder("-1"));
            } else if (ans.charAt(0) == '0') {
                StringBuilder tsb = new StringBuilder(ans.substring(1, ans.length()));
                printSb(t, tsb);
            } else {
                printSb(t, ans);
            }
        }
        System.out.println(sb.toString());
    }

    private static void printSb(int t, StringBuilder val) {
        sb.append("#").append(t).append(" ").append(val).append("\n");
    }

}
