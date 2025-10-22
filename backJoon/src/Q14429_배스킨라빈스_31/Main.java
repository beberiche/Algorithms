package Q14429_배스킨라빈스_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            num -= (num - 1) % (m + 1);
            int count = 2 * (num / m + 1);

            if (result[1] > count) {
                result[0] = i;
                result[1] = count;
            }
        }

        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }
}
