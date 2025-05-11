package Q3062_수_뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int num1 = Integer.parseInt(str);
            int num2 = Integer.parseInt(new StringBuilder(str).reverse().toString());
            sb.append(check(num1 + num2)).append("\n");
        }
        System.out.print(sb);
    }

    private static String check(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }
}
