package Q1233_주사위;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(stk.nextToken());
        int s2 = Integer.parseInt(stk.nextToken());
        int s3 = Integer.parseInt(stk.nextToken());

        int[][] a = new int[101][2];
        for (int i = 1; i < a.length; i++) {
            a[i][0] = i;
        }

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    a[i + j + k][1]++;
                }
            }
        }

        Arrays.sort(a, ((n1, n2) -> {
            if (n1[1] == n2[1]) return n1[0] - n2[0];
            else return n2[1] - n1[1];
        }));

        System.out.println(a[0][0]);
    }
}
