package Q1009_분산처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (--N >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            int ret = 1;
            for (int i = 0; i < b; i++) {
                ret *= a;
                ret %= 10;
            }

            sb.append(ret == 0 ? 10 : ret).append("\n");
        }
        System.out.print(sb);
    }
}
