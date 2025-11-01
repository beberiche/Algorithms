package Q6378_디지털_루트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String S = br.readLine();
            if (S.equals("0")) break;

            while (true) {
                int sum = 0;
                if (S.length() < 2) {
                    break;
                } else {
                    for (int i = 0; i < S.length(); i++) {
                        sum += S.charAt(i) - '0';
                    }
                }
                S = String.valueOf(sum);
            }
            sb.append(S).append("\n");
        }
        System.out.print(sb);
    }
}
