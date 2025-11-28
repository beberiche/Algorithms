package Q9046_복호화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--N >= 0) {
            String input = br.readLine();
            int[] result = new int[26];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    result[input.charAt(i) - 'a']++;
                }
            }

            int max = 0;
            for (int r : result) {
                if (r > max) {
                    max = r;
                }
            }

            int count = 0;
            int answer = 0;
            for (int j = 0; j < 26; j++) {
                if (max == result[j]) {
                    count++;
                    answer = j;
                }
            }

            sb.append(count == 1 ? (char) (answer + 'a') : "?").append("\n");
        }
        System.out.print(sb);
    }
}
