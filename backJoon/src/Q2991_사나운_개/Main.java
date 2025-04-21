package Q2991_사나운_개;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        int D = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(stk.nextToken());
            int Fdog = N % (A + B);
            int Sdog = N % (C + D);
            int count = 0;

            if (Fdog <= A && Sdog <= C) {
                count = 2;
            } else if (Fdog <= A || Sdog <= C) {
                count = 1;
            }

            if (Fdog == 0) {
                count -= 1;
            }
            if (Sdog == 0) {
                count -= 1;
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
