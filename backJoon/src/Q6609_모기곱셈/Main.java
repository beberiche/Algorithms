package Q6609_모기곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(str);
            int M = Integer.parseInt(stk.nextToken());
            int P = Integer.parseInt(stk.nextToken());
            int L = Integer.parseInt(stk.nextToken());
            int E = Integer.parseInt(stk.nextToken());
            int R = Integer.parseInt(stk.nextToken());
            int S = Integer.parseInt(stk.nextToken());
            int N = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < N; i++) {
                int m = M;
                M = P / S;
                P = L / R;
                L = m * E;
            }
            sb.append(M).append("\n");
        }
        System.out.print(sb);
    }
}
