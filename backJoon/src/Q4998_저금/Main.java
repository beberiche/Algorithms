package Q4998_저금;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            try {
                StringTokenizer stk = new StringTokenizer(br.readLine());

                double start = Double.parseDouble(stk.nextToken());
                double rate = Double.parseDouble(stk.nextToken());
                double target = Double.parseDouble(stk.nextToken());

                int count = 0;
                while (start < target) {
                    start += start * rate / 100.0;
                    count++;
                }
                sb.append(count).append("\n");
            } catch (Exception e) {
                break;
            }
        }
        System.out.print(sb);
    }
}
