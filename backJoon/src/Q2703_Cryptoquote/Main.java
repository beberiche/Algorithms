package Q2703_Cryptoquote;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--T >= 0) {
            String quote = br.readLine();
            String key = br.readLine();
            for (int i = 0; i < quote.length(); i++) {
                if (quote.charAt(i) == ' ') {
                    sb.append(" ");
                } else {
                    sb.append(key.charAt(quote.charAt(i) - 'A'));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
