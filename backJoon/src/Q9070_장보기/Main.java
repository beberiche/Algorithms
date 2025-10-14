package Q9070_장보기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            double totalPrice = 0;
            double min = Double.MAX_VALUE;

            int answer = 0;
            for (int j = 0; j < num; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int W = Integer.parseInt(stk.nextToken());
                int C = Integer.parseInt(stk.nextToken());

                totalPrice = (double) C / W;

                if (min > totalPrice) {
                    min = totalPrice;
                    answer = (int) C;
                } else if (totalPrice == min && C < answer) {
                    answer = C;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
