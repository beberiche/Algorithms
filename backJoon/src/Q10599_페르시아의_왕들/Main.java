package Q10599_페르시아의_왕들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            if (a == 0 && b == 0 && c == 0 && d == 0) break;

            sb.append(c - b).append(" ").append(d - a).append("\n");
        }
        System.out.print(sb);
    }
}
