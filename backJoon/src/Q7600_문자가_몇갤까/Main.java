package Q7600_문자가_몇갤까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine().toLowerCase();
            if (str.equals("#")) {
                break;
            }

            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (idx >= 0 && idx < 26) {
                    arr[str.charAt(i) - 'a']++;
                }
            }

            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
