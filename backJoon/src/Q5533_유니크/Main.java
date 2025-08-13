package Q5533_유니크;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                boolean isUnique = true;
                for (int k = 0; k < N; k++) {
                    if (j != k && a[j][i] == a[k][i]) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    result[j] += a[j][i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}
