package Q4458_첫_글자를_대문자로;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < str.length; j++) {
                if (j == 0) {
                    str[j] = Character.toUpperCase(str[j]);
                }
                sb2.append(str[j]);
            }
            sb.append(sb2).append("\n");
        }
        System.out.print(sb);
    }
}
