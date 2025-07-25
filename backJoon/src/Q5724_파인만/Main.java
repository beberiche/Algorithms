package Q5724_파인만;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            for (int i = 1; i <= N; i++) {
                sum += i * i;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
