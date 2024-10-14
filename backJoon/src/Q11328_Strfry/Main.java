package Q11328_Strfry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--N >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String s1 = stk.nextToken();
            String s2 = stk.nextToken();
            int[] a = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                a[s1.charAt(i) - 'a']++;
            }

            for (int i = 0; i < s2.length(); i++) {
                a[s2.charAt(i) - 'a']--;
            }

            boolean check = true;
            for (int i = 0; i < 26; i++) {
                if (a[i] != 0) {
                    check = false;
                    break;
                }
            }

            sb.append(check ? "Possible" : "Impossible").append("\n");
        }
        System.out.print(sb.toString());
    }
}
