package Q1264_모음의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();

            if (str.equals("#")) {
                System.out.print(sb.toString());
                return;
            }

            int cnt = 0;
            String cmp = "aeiouAEIOU";
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < cmp.length(); j++) {
                    if (str.charAt(i) == cmp.charAt(j)) {
                        cnt++;
                        break;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
    }
}
