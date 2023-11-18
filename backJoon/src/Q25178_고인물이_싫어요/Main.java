package Q25178_고인물이_싫어요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int waters[], p[], clean[], dirty[];

    private static int find(int num) {

        if (p[num] == num) return num;
        return p[num] = find(p[num]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        waters = new int[N + 1];
        p = new int[N + 1];
        clean = new int[N + 1];
        dirty = new int[N + 1];
        stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            waters[i] = Integer.parseInt(stk.nextToken());
            if (waters[i] == 1) clean[i] = 1;
            else dirty[i] = 1;
            p[i] = i;
        }


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int n1 = find(Integer.parseInt(stk.nextToken()));
            int n2 = find(Integer.parseInt(stk.nextToken()));

            if (n1 < n2) {
                p[n2] = n1;
                clean[n1] += clean[n2];
                dirty[n1] += dirty[n2];
            } else if (n1 > n2) {
                p[n1] = n2;
                clean[n2] += clean[n1];
                dirty[n2] += dirty[n1];
            }

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int num = find(Integer.parseInt(br.readLine()));
            sb.append(dirty[num] < clean[num] ? 1 : 0).append("\n");
        }
        System.out.print(sb.toString());
    }
}
