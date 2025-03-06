package Q2774_아름다운_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (--N >= 0) {
            String str = br.readLine();
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                s.add(ch - '0');
            }
            sb.append(s.size()).append("\n");
        }
        System.out.print(sb);
    }
}
