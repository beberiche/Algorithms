package Q1946_신입_사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] a = new int[N][];

            for (int i = 0; i < N; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                a[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
            }

            Arrays.sort(a, (n1, n2) -> n1[0] - n2[0]);

            int ret = 1;
            int idx = 0;

            for (int i = 1; i < N; i++) {
                if (a[idx][1] > a[i][1]) {
                    ret++;
                    idx = i;
                }
            }
            sb.append(ret).append("\n");
        }

        System.out.print(sb.toString());
    }

}
