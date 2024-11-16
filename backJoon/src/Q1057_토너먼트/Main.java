package Q1057_토너먼트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int n1 = Integer.parseInt(stk.nextToken());
        int n2 = Integer.parseInt(stk.nextToken());

        int cnt = 1;
        int div = 2;
        while (cnt <= 17) {
            int nn1 = n1 % div == 0 ? (n1 / div) : (n1 / div) + 1;
            int nn2 = n2 % div == 0 ? (n2 / div) : (n2 / div) + 1;

            if (nn1 == nn2) break;

            cnt++;
            div *= 2;
        }

        System.out.println(cnt);

    }
}
