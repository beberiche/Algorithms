package Q2386_도비의_영어_공부;

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
            char ch = stk.nextToken().charAt(0);
            if (ch == '#') {
                break;
            }
            StringBuilder str = new StringBuilder();
            while(stk.hasMoreTokens()){
                str.append(stk.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                char cmp = str.charAt(i);
                if (ch == cmp || Character.toUpperCase(ch)==cmp) {
                    cnt++;
                }
            }

            sb.append(ch).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
