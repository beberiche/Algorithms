package Q11586_지영_공주님의_마법_거울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];

        for (int i = 0; i < T; i++) {
            str[i] = br.readLine();
        }
        int mind = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String line = str[i];
            String reverseLine = str[str.length - 1 - i];
            for (int j = 0; j < line.length(); j++) {
                if (mind == 1) {
                    sb.append(line.charAt(j));
                } else if (mind == 2) {
                    sb.append(line.charAt(line.length() - 1 - j));
                } else if (mind == 3) {
                    sb.append(reverseLine.charAt(j));
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
