package Q9366_삼각형_분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int[] a = new int[3];
            StringTokenizer stk = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                a[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(a);
            sb.append("Case #").append(i).append(": ");

            if (a[0] + a[1] > a[2]) {
                if (a[0] == a[1] && a[1] == a[2]) {
                    sb.append("equilateral");
                } else if (a[0] == a[1] || a[1] == a[2]) {
                    sb.append("isosceles");
                } else {
                    sb.append("scalene");
                }
            } else {
                sb.append("invalid!");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
