package Q5086_배수와_약수;

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

            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());

            if (first == 0 && second == 0) break;

            if (second % first == 0) {
                sb.append("factor");
            } else if (first % second == 0) {
                sb.append("multiple");
            } else {
                sb.append("neither");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}