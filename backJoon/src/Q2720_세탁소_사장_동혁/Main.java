package Q2720_세탁소_사장_동혁;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[]{25, 10, 5, 1};
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] cnt = new int[a.length];
            for (int j = 0; j < a.length; j++) {
                cnt[j] = num / a[j];
                num %= a[j];
                sb.append(cnt[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
