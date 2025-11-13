package Q10040_투표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[N];
        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                if (cost[j] <= c) {
                    cnt[j]++;
                    break;
                }
            }
        }

        int idx = -1;
        int curr = -1;
        for (int i = 0; i < N; i++) {
            if (cnt[i] > curr) {
                curr = cnt[i];
                idx = i;
            }
        }
        System.out.print(idx + 1);
    }
}
