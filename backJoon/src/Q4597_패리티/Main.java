package Q4597_패리티;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();

            if (str.equals("#")) {
                break;
            }

            char parity = str.charAt(str.length() - 1);
            int cnt = 0;
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == '1') {
                    cnt++;
                }
            }

            String ans;
            if ((cnt % 2 == 0 && parity == 'e') || (cnt % 2 == 1 && parity == 'o')) {
                ans = "0";
            } else {
                ans = "1";
            }
            sb.append(str.substring(0, str.length() - 1)).append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
