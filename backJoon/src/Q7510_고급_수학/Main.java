package Q7510_고급_수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            boolean check1 = Math.sqrt(a * a + b * b) == c;
            boolean check2 = Math.sqrt(a * a + c * c) == b;
            boolean check3 = Math.sqrt(b * b + c * c) == a;
            sb.append("Scenario #").append(i + 1).append(":\n");
            sb.append(check1 || check2 || check3 ? "yes" : "no").append("\n").append("\n");
        }
        System.out.print(sb);
    }
}
