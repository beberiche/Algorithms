package Q5988_홀수일까_짝수일까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int num = str.charAt(str.length() - 1) - '0';
            sb.append(num % 2 == 1 ? "odd" : "even").append("\n");
        }
        System.out.print(sb);
    }
}
