package Q6246_풍선_놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());

        boolean[] line = new boolean[N];
        for (int i = 0; i < Q; i++) {
            stk = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(stk.nextToken());
            int I = Integer.parseInt(stk.nextToken());

            for (int j = L - 1; j < N; j += I) {
                line[j] = true;
            }
        }

        int ans = 0;
        for (boolean b : line) {
            if (!b) ans++;
        }

        System.out.print(ans);
    }
}
