package Q1681_줄_세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        String L = stk.nextToken();

        int cnt = 0;
        int max = 1;
        while (cnt != N) {
            if ((max + "").contains(L)) {
                max++;
                continue;
            }
            max++;
            cnt++;
        }

        System.out.println(max-1);
    }
}
