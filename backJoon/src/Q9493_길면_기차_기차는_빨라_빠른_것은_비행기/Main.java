package Q9493_길면_기차_기차는_빨라_빠른_것은_비행기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (m == 0 && a == 0 && b == 0) break;

            double timeDiff = (double) m / a - (double) m / b;
            int totalSeconds = (int) Math.round(timeDiff * 3600);

            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            sb.append(String.format("%d:%02d:%02d", hours, minutes, seconds)).append("\n");
        }
        System.out.print(sb);
    }
}
