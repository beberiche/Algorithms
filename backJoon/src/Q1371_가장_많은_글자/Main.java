package Q1371_가장_많은_글자;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[26];
        int max = 0;
        String str;
        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch != ' ') {
                    a[ch - 'a']++;
                    max = Math.max(max, a[ch - 'a']);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                sb.append((char) (i + 'a'));
            }
        }
        System.out.print(sb.toString());
    }
}
