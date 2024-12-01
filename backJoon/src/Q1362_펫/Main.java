package Q1362_펫;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            double o050 = (o * 0.5);
            double o200 = (o * 2.0);
            if (o == 0 && w == 0) break;

            boolean isDead = false;
            while (true) {
                stk = new StringTokenizer(br.readLine());
                char cmd = stk.nextToken().charAt(0);
                int n = Integer.parseInt(stk.nextToken());

                if (w <= 0) {
                    isDead = true;
                }

                if (cmd == '#' && n == 0) {
                    break;
                }
                if (cmd == 'F') {
                    w += n;
                } else {
                    w -= n;
                }
            }
            String ret = ":-)";
            if (isDead) {
                ret = "RIP";
            } else if (w <= o050 || w >= o200) {
                ret = ":-(";
            }
            sb.append(cnt++).append(" ").append(ret).append("\n");
        }
        System.out.print(sb);
    }
}
