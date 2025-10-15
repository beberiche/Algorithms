package Q6322_직각_삼각형의_두_변;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(stk.nextToken());
            double b = Double.parseDouble(stk.nextToken());
            double c = Double.parseDouble(stk.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            sb.append("Triangle #").append(++i).append("\n");

            if (a == -1) {
                if (c <= b) {
                    sb.append("Impossible.");
                } else {
                    a = Math.sqrt((c * c) - (b * b));
                    sb.append("a = " + String.format("%.3f", a));
                }
            }
            if (b == -1) {
                if (c <= a) {
                    sb.append("Impossible.");
                } else {
                    b = Math.sqrt((c * c) - (a * a));
                    sb.append("b = " + String.format("%.3f", b));
                }
            }
            if (c == -1) {
                c = Math.sqrt((a * a) + (b * b));
                sb.append("c = " + String.format("%.3f", c));
            }
            sb.append("\n").append("\n");
        }
        System.out.print(sb);
    }
}
