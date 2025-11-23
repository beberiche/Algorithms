package Q10865_친구_친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] cnt = new int[n + 1];
        while (m-- > 0) {
            stk = new StringTokenizer(br.readLine());
            cnt[Integer.parseInt(stk.nextToken())]++;
            cnt[Integer.parseInt(stk.nextToken())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]).append('\n');
        }
        System.out.print(sb);
    }
}