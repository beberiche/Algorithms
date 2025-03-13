package Q2711_오타맨_고창영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ret = new StringBuilder();
        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(stk.nextToken());
            StringBuilder sb = new StringBuilder(stk.nextToken());
            sb.deleteCharAt(idx - 1);
            ret.append(sb).append("\n");
        }
        System.out.print(ret);
    }
}
