package Q1871_좋은_자동차_번호판;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--N >= 0) {
            String[] a = br.readLine().split("-");
            String s1 = a[0];
            String s2 = a[1];

            int n1 = 26 * 26 * (s1.charAt(0) - 'A') + 26 * (s1.charAt(1) - 'A') + (s1.charAt(2) - 'A');
            int n2 = Integer.parseInt(s2);

            sb.append(Math.abs(n1 - n2) <= 100 ? "nice" : "not nice").append("\n");
        }
        System.out.print(sb);
    }
}
