package Q19539_사과나무;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int n1 = 0;
        int n2 = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(stk.nextToken());
            n1 += num;
            n2 += num / 2;
        }

        System.out.println(n1 % 3 == 0 && n2 >= n1 / 3 ? "YES" : "NO");
    }
}
