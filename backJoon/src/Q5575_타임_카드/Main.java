package Q5575_타임_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int time = 0;
            int time2 = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int h = Integer.parseInt(stk.nextToken());
                int m = Integer.parseInt(stk.nextToken());
                int s = Integer.parseInt(stk.nextToken());
                if (j == 0) {
                    time = (h * 3600) + (m * 60) + s;
                } else {
                    time2 = (h * 3600) + (m * 60) + s;
                }
            }
            time2 -= time;
            sb.append(time2 / 3600).append(" ").append((time2 % 3600) / 60).append(" ").append((time2 % 3600) % 60).append("\n");
        }
        System.out.print(sb);
    }
}