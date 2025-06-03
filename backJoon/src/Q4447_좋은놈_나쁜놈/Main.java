package Q4447_좋은놈_나쁜놈;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();

            int goodGuys = 0;
            int badGuys = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = Character.toLowerCase(str.charAt(j));

                if (c == 'g') {
                    goodGuys++;
                } else if (c == 'b') {
                    badGuys++;
                }
            }
            sb.append(str).append(" ").append("is ");
            // Determine the result based on the number of good and bad guys
            if (goodGuys > badGuys) {
                sb.append("GOOD\n");
            } else if (goodGuys < badGuys) {
                sb.append("A BADDY\n");
            } else {
                sb.append("NEUTRAL\n");
            }
        }
        System.out.print(sb);
    }
}
