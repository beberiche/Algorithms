package Q7789_텔레프라임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(stk.nextToken());
        int next = Integer.parseInt(stk.nextToken()) * (int) 1e6 + num;
        int max = (int) 1e7;


        boolean[] check = new boolean[max + 1];
        check[0] = check[1] = true;
        outer:
        for (int i = 2; i <= (int) Math.sqrt(next); i++) {
            if (check[i]) continue;
            for (int j = i * i; j <= max; j += i) {
                check[j] = true;
                if (j == num || j == next) break outer;
            }
        }

        System.out.println(!check[num] && !check[next] ? "Yes" : "No");
    }
}
