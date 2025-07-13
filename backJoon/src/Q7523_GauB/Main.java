package Q7523_GauB;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            long st = Long.parseLong(stk.nextToken());
            long ed = Long.parseLong(stk.nextToken());

            long diff = ed - st + 1;
            long sum = (diff) * (st + ed) / 2;
            sb.append("Scenario #").append(t).append(":\n");
            sb.append(sum).append("\n\n");
        }
        System.out.print(sb);
    }
}
