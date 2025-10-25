package Q11109_괴짜_교수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final String DO_NOT_PARALLEL = "do not parallelize";
        final String DOES_NOT_MATTER = "does not matter";
        final String PARALLEL = "parallelize";
        String ans;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            int p = Integer.parseInt(stk.nextToken());

            int serialize = n * s;
            int parallel = n * p + d;


            if (serialize == parallel) {
                ans = DOES_NOT_MATTER;
            } else if (serialize < parallel) {
                ans = DO_NOT_PARALLEL;
            } else {
                ans = PARALLEL;
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
