package Q3449_해밍_거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String ans = "Hamming distance is ";
        for (int i = 0; i < N; i++) {
            String x = br.readLine();
            String y = br.readLine();

            int cnt = 0;
            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) != y.charAt(j)) {
                    cnt++;
                }
            }
            sb.append(ans).append(cnt).append(".\n");
        }
        System.out.print(sb);
    }
}
