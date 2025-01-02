package Q1919_애너그램_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int length = 26;
        int[] a1 = new int[length];
        int[] a2 = new int[length];

        go(s1, a1);
        go(s2, a2);
        int total = s1.length() + s2.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.min(a1[i], a2[i]) * 2;
        }
        System.out.println(total-sum);
    }

    private static void go(String s, int[] a) {
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
    }
}
