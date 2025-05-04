package Q3034_앵그리_창영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int H = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n <= W) {
                sb.append("DA");
            } else if (n <= H) {
                sb.append("DA");
            } else if (n <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
