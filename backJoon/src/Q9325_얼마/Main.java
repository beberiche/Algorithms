package Q9325_얼마;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int sum = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                sum += (q * p);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
