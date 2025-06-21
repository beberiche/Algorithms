package Q4892_숫자_맞추기_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String str = n % 2 == 0 ? "even" : "odd";
            int result = n % 2 == 0 ? (((n * 3) / 2) * 3) / 9 : ((((n * 3) + 1) / 2) * 3) / 9;
            sb.append(count).append(". ").append(str).append(" ").append(result).append("\n");
            count++;
        }
        System.out.print(sb);
    }
}
