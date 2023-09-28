package Q3066_브리징_시그널;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    private static int binarySearch(List<Integer> list, int num) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (num <= list.get(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    private static void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        list.add(Integer.parseInt(br.readLine()));
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (list.get(list.size() - 1) < num) {
                list.add(num);
                continue;
            }

            int idx = binarySearch(list, num);
            list.set(idx, num);
        }

        sb.append(list.size()).append("\n");
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            solve();
        }
        output();
    }
}
