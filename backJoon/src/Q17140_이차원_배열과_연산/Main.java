package Q17140_이차원_배열과_연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static int R, C, K, ans;

    static class Node {
        int num;
        int cnt;

        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static Map<Integer, Node> m;
    static PriorityQueue<Node> pq;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            stk = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());
            list.get(i).add(Integer.parseInt(stk.nextToken()));
            list.get(i).add(Integer.parseInt(stk.nextToken()));
            list.get(i).add(Integer.parseInt(stk.nextToken()));
        }

    }

    private static List<List<Integer>> rotate(int r_len, int c_len) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < c_len; i++) {
            ret.add(new ArrayList<>());
            for (int j = 0; j < r_len; j++) {
                ret.get(i).add(list.get(j).get(i));
            }
        }

        return ret;
    }

    private static void go() {
        int maxLen = 0;
        for (int i = 0; i < list.size(); i++) {
            m = new HashMap<>();
            for (int n : list.get(i)) {
                if (n == 0) continue;
                if (m.get(n) == null) {
                    m.put(n, new Node(n, 1));
                } else {
                    m.put(n, new Node(n, m.get(n).cnt + 1));
                }
            }

            pq = new PriorityQueue<>((n1, n2) -> {
                if (n1.cnt == n2.cnt) return n1.num - n2.num;
                return n1.cnt - n2.cnt;
            });
            pq.addAll(m.values());

            List<Integer> ret = new ArrayList<>();
            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                ret.add(curr.num);
                ret.add(curr.cnt);
            }
            maxLen = Math.max(maxLen, ret.size());
            list.set(i, ret);
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == maxLen) continue;
            int cnt = maxLen - list.get(i).size();
            while (--cnt >= 0) {
                list.get(i).add(0);
            }
        }
    }

    private static void solve() {
        ans = 0;
        while (ans <= 100) {
            if (list.size() >= R && list.get(0).size() >= C && list.get(R - 1).get(C - 1) == K) {
                break;
            }
            if (list.size() >= list.get(0).size()) {
                go();
            } else {
                list = rotate(list.size(), list.get(0).size());
                go();
                list = rotate(list.size(), list.get(0).size());
            }
            ans++;
        }
    }


    private static void output() {
        System.out.println(ans > 100 ? -1 : ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
