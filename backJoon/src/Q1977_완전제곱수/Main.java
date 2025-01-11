package Q1977_완전제곱수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            int num = i*i;
            if (M <= num && num <= N) {
                min = Math.min(min, num);
                sum += num;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }
        System.out.print(sb);
    }
}
