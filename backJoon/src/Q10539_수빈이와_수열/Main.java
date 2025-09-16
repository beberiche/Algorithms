package Q10539_수빈이와_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(stk.nextToken());

            if (i == 0) {
                arr[0] = M;
            } else {
                arr[i] = (M * (i + 1)) - sum;
            }

            sum += arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int K : arr) {
            sb.append(K).append(" ");
        }
        System.out.print(sb);
    }
}
