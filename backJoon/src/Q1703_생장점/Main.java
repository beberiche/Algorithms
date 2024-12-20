package Q1703_생장점;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = 1;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            if (a == 0) break;

            for (int i = 0; i < a; i++) {
                b *= Integer.parseInt(stk.nextToken());
                b -= Integer.parseInt(stk.nextToken());
            }
            sb.append(b).append("\n");
        }
        System.out.print(sb);
    }
}
