package Q1816_암호_키;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            for (int j = 2; j <= 1000000; j++) {
                if (num % j == 0) {
                    sb.append("NO").append("\n");
                    break;
                }

                if(j==1000000) sb.append("YES").append("\n");
            }
        }

        System.out.print(sb);
    }
}
