package Q1032_명령_프롬프트;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] s = br.readLine().toCharArray();
        for (int i = 1; i < N; i++) {
            String cmp = br.readLine();
            for (int j = 0; j < s.length; j++) {
                if (s[j] == '?') continue;
                if (cmp.charAt(j) != s[j]) s[j] = '?';
            }
        }
        System.out.println(new String(s));
    }
}
