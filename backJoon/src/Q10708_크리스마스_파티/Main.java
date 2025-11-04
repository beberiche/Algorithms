package Q10708_크리스마스_파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] targets = new int[M];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(stk.nextToken()) - 1;
        }

        int[] a = new int[N];

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            stk = new StringTokenizer(br.readLine());

            int w = 0;

            for (int j = 0; j < N; j++) {
                int guess = Integer.parseInt(stk.nextToken()) - 1;

                if (j == target) {
                    a[j]++;
                } else if (guess == target) {
                    a[j]++;
                } else {
                    w++;
                }
            }

            a[target] += w;
        }

        for (int s : a) {
            sb.append(s).append('\n');
        }

        System.out.print(sb.toString());
    }
}
