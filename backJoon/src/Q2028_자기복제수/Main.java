package Q2028_자기복제수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            String s1 = Integer.toString(num * num);
            String s2 = Integer.toString(num);
            String sub1 = s1.substring(s1.length() - s2.length(), s1.length());

            sb.append(sub1.equals(s2) ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
