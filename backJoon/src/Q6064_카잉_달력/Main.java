package Q6064_카잉_달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            long ans = x-1;

            while (true) {
                if (ans % N + 1 == y) {
                    sb.append(ans+1).append("\n");
                    break;
                }
                if (ans > N * M) {
                    sb.append(-1).append("\n");
                    break;
                }
                ans += M;
            }
        }
        System.out.println(sb.toString());
    }


}

