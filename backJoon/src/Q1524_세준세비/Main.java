package Q1524_세준세비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            br.readLine();
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int smax = 0;
            int bmax = 0;

            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                smax = Math.max(smax, Integer.parseInt(stk.nextToken()));
            }

            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                bmax = Math.max(bmax, Integer.parseInt(stk.nextToken()));
            }

            sb.append(smax >= bmax ? "S" : "B").append("\n");
        }
        System.out.print(sb);
    }
}
