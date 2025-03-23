package Q2804_크로스워드_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        String a = stk.nextToken();
        String b = stk.nextToken();
        getSameCharIndex(a, b);
        print(a, b);
    }

    private static void print(String a, String b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < b.length(); i++) {
            if (i == y) {
                sb.append(a).append("\n");
                continue;
            }

            for (int j = 0; j < a.length(); j++) {
                if (j == x) {
                    sb.append(b.charAt(i));
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void getSameCharIndex(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i);
            for (int j = 0; j < b.length(); j++) {
                char bChar = b.charAt(j);
                if (aChar == bChar) {
                    x = i;
                    y = j;
                    return;
                }
            }
        }
    }
}
