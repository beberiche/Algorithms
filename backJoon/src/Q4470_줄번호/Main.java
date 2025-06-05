package Q4470_줄번호;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String line = br.readLine();
            sb.append(i).append(". ").append(line).append("\n");
        }
        System.out.print(sb.toString());
    }
}
