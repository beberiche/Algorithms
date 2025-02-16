package Q2495_연속구간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 3; tc++) {
            String s = br.readLine();
            int max = 0;

            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                i++;
                int len = 1;
                while (i < s.length() && s.charAt(i) == c) {
                    i++;
                    len++;
                }
                max = Math.max(max, len);
            }
            System.out.println(max);
        }
    }
}

