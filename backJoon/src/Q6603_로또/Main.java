package Q6603_로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> list;
    private static int K, a[];
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            K = Integer.parseInt(stk.nextToken());

            if (K == 0) {
                System.out.print(sb.toString());
                return;
            }

            a = new int[K];

            for (int i = 0; i < K; i++) {
                a[i] = Integer.parseInt(stk.nextToken());
            }

            list = new ArrayList<>();

            go(0);
            sb.append("\n");
        }
    }

    private static void go(int idx) {
        if (list.size() >= 6) {
            for (int n : list) sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i < K; i++) {
            list.add(a[i]);
            go(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
