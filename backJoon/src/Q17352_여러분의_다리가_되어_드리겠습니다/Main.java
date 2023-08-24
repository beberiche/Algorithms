package Q17352_여러분의_다리가_되어_드리겠습니다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int p[];

    private static int find(int num) {
        if (num == p[num]) return num;
        return p[num] = find(p[num]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }


        for (int i = 0; i < N - 2; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
//            if (st > ed) {
//                int tmp = st;
//                st = ed;
//                ed = tmp;
//            }

            int x = find(st);
            int y = find(ed);

            if (x < y) {
                p[y] = x;
            } else {
                p[x] = y;
            }
        }

        int prev = find(p[1]);
        for (int i = 2; i <= N; i++) {
            int curr = find(p[i]);
            if (prev != curr) {
                System.out.print(prev + " " + curr);
                break;
            }
            prev = curr;
        }
    }
}
