package Q4880_다음수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());
            int C = Integer.parseInt(stk.nextToken());

            if(A == 0 && B == 0 && C == 0) break;

            int N = B - A;
            int M = C - B;

            String result = (N == M) ? ("AP " + (C + M)) : ("GP " + (C + (M * (M / N))));

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
