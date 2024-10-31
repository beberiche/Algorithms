package Q1145_적어도_대부분의_배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int a[] = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        int num = 1;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (num % a[i] == 0) {
                    cnt++;
                }
            }

            if (cnt >= 3) break;
            num++;
        }

        System.out.println(num);
    }
}
