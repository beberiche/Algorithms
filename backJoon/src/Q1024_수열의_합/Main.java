package Q1024_수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());

        // N = i * start + (i * (i - 1)) / 2
        // start = (N - (i * (i - 1)) / 2) / i
        String ans = "-1";
        for (int i = L; i <= 100; i++) {
            int sum = (i * (i - 1)) / 2;
            if ((N - sum) % i == 0) {
                int start = (N - sum) / i;
                if (start < 0) continue;

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(start + j).append(" ");
                }
                ans = sb.toString().trim();
                break;
            }
        }
        System.out.println(ans);
    }
}
