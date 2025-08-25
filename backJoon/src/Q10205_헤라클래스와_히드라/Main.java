package Q10205_헤라클래스와_히드라;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("Data Set ").append(t).append(":").append("\n");
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'c') {
                    N += 2;
                }
                N--;
                if (N == 0) {
                    break;
                }
            }
            sb.append(N).append("\n").append("\n");
        }
        System.out.print(sb);
    }
}
