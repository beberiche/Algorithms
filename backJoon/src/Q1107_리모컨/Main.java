package Q1107_리모컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int goal, curr, ans, N, cnt;
    static boolean[] fix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goal = Integer.parseInt(br.readLine());
        curr = 100;
        ans = Math.min(Math.abs(goal - curr), Math.abs(curr - goal));
        N = Integer.parseInt(br.readLine());
        fix = new boolean[10];
        if (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                fix[Integer.parseInt(st.nextToken())] = true;
            }
        }

        char[] goalArr = String.valueOf(goal).toCharArray();
        cnt = goalArr.length;
        if(cnt<6) dupPerm(0, cnt + 1, "");
        if(cnt>1) dupPerm(0, cnt - 1, "");
        dupPerm(0, cnt, "");
        System.out.println(ans);

    }

    private static void dupPerm(int len, int cnt, String perm) {
        if (cnt <= len) {
            int temp = Integer.parseInt(perm);
            ans = Math.min(ans, Math.min(Math.abs(goal - temp) + len, Math.abs(temp - goal) + len));
            return;
        }

        if (len >= 2 && perm.charAt(0) == '0') {
            return;
        }

        for (int i = 0; i < fix.length; i++) {
            if (!fix[i]) dupPerm(len + 1, cnt, perm + String.valueOf(i));
        }
    }
}
