package Q3226_전화_요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String line = stk.nextToken();
            int H = Integer.parseInt(line.substring(0, 2));
            int M = Integer.parseInt(line.substring(3, 5));
            int D = Integer.parseInt(stk.nextToken());

            int end_H = H, end_M = M;

            if (M + D < 60) {
                end_M = M + D;
            } else {
                int Q = (M + D) / 60;
                end_M = (M + D) % 60;
                if (H + Q < 24) {
                    end_H = H + Q;
                } else {
                    end_H = (H + Q) % 24;
                }
            }

            if (H == 6 && end_H == 7) {
                ans += (D - end_M) * 5 + end_M * 10;
            } else if (H == 18 && end_H == 19) {
                ans += (D - end_M) * 10 + end_M * 5;
            } else {
                if (6 < H && H < 19) {
                    ans += 10 * D;
                } else {
                    ans += 5 * D;
                }
            }
        }
        System.out.println(ans);
    }
}
