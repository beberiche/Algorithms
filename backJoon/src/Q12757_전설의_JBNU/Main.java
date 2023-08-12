package Q12757_전설의_JBNU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static TreeMap<Integer, Integer> m;
    static BufferedReader br;
    static StringTokenizer stk;
    static StringBuilder sb = new StringBuilder();
    static int INF = 1_000_000_000 + 4;

    private static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        m = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            m.put(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
    }


    private static void solve() throws Exception {
        int num, cmd, unum;
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(stk.nextToken());

            if (cmd == 1) {
                num = Integer.parseInt(stk.nextToken());
                unum = Integer.parseInt(stk.nextToken());
                m.put(num, unum);
            } else if (cmd == 2) {
                num = Integer.parseInt(stk.nextToken());
                unum = Integer.parseInt(stk.nextToken());
                if (m.containsKey(num)) m.put(num, unum);
                else {
                    Integer n1 = m.floorKey(num);
                    Integer n2 = m.ceilingKey(num);

                    if (n1 == null) n1 = INF;
                    if (n2 == null) n2 = INF;

                    int diff1 = Math.abs(num - n1);
                    int diff2 = Math.abs(n2 - num);

                    if (diff1 > K && diff2 > K) continue;
                    if (diff1 == diff2) continue;

                    m.put(diff1 < diff2 ? n1 : n2, unum);
                }
            } else {
                num = Integer.parseInt(stk.nextToken());
                if (m.containsKey(num)) sb.append(m.get(num));
                else {
                    Integer n1 = m.floorKey(num);
                    Integer n2 = m.ceilingKey(num);

                    if (n1 == null) n1 = INF;
                    if (n2 == null) n2 = INF;

                    int diff1 = Math.abs(num - n1);
                    int diff2 = Math.abs(n2 - num);

                    if (diff1 > K && diff2 > K) {
                        sb.append(-1);
                    } else if (diff1 == diff2) {
                        sb.append("?");
                    } else {
                        sb.append((diff1 < diff2 ? m.get(n1) : m.get(n2)));
                    }
                }
                sb.append("\n");
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
