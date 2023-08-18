package Q2568_전깃줄_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, idx, arr[][];
    static List<int[]> list, list2;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
        }

        Collections.sort(list, (n1, n2) -> n1[0] - n2[0]);
    }

    private static int lowerBound(int target, int right) {
        int l = 0;
        int r = right+1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (list2.get(mid)[1] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    private static void solve() {
        arr = new int[N][2];
        list2 = new ArrayList<>();

        list2.add(list.get(0));
        arr[0] = new int[]{0, list.get(0)[0]};
        for (int i = 1; i < N; i++) {
            if (list2.get(list2.size() - 1)[1] < list.get(i)[1]) {
                list2.add(list.get(i));
                arr[i] = new int[]{++idx, list.get(i)[0]};
            } else {
                int n = lowerBound(list.get(i)[1], idx);
                list2.set(n, list.get(i));
                arr[i] = new int[]{n, list.get(i)[0]};
            }
        }
    }

    private static void output() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i][0] != idx) pq.add(arr[i][1]);
            else idx--;
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
