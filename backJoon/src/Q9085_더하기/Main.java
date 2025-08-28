package Q9085_더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Integer.parseInt(stk.nextToken());
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
