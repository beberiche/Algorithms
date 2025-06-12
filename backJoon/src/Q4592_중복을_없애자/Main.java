package Q4592_중복을_없애자;

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
            int n = Integer.parseInt(stk.nextToken());

            if (n == 0) break;

            int defaultNum = Integer.parseInt(stk.nextToken());
            sb.append(defaultNum).append(" ");

            for (int i = 0; i < n - 1; i++) {
                int nextNum = Integer.parseInt(stk.nextToken());
                if (defaultNum != nextNum) {
                    sb.append(nextNum).append(" ");
                    defaultNum = nextNum;
                }
            }
            sb.append("$").append("\n");
        }
        System.out.print(sb);
    }
}
