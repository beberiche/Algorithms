package Q1111_IQ_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<Integer, Integer> m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.print("A");
            return;
        }

        int[] a = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        boolean same = allSame(a);
        if (same) {
            System.out.println(a[0]);
            return;
        }

        if (N == 2 && !same) {
            System.out.println("A");
            return;
        }

        int y = a[N - 1];
        int x = a[N - 2];

        m = new TreeMap<>();

        for (int i = -200; i <= 200; i++) {
            m.put(i, y - (x * i));
        }

        List<int[]> prev = findCal(x, y);

        for (int i = 1; i < N - 1; i++) {
            List<int[]> curr = findCal(a[i - 1], a[i]);

            if (prev.size() != curr.size()) {
                curr = prev.size() < curr.size() ? prev : curr;
            }

            // 둘의 산술 길이가 1개인데
            // 두 산술이 서로 다른 경우
            if (prev.size() == curr.size() && prev.size() == 1 && !calCheck(curr, prev)) {
                System.out.println("B");
                return;
            }

            prev = curr;
        }

        if (prev.size() > 1) {
            System.out.println("A");
        } else if (prev.isEmpty()) {
            System.out.println("B");
        } else {
            System.out.println(prev.get(0)[0] * a[N - 1] + prev.get(0)[1]);
        }

    }

    private static boolean calCheck(List<int[]> prev, List<int[]> curr) {
        return prev.get(0)[0] == curr.get(0)[0] && prev.get(0)[1] == curr.get(0)[1];
    }

    private static boolean allSame(int[] a) {
        boolean same = true;
        int num = a[0];
        for (int i = 1; i < a.length; i++) {
            if (num != a[i]) {
                same = false;
                break;
            }
        }
        return same;
    }


    private static List<int[]> findCal(int a, int b) {
        List<int[]> list = new ArrayList<>();
        for (int i = -200; i <= 200; i++) {
            if (a * i + m.get(i) == b) {
                list.add(new int[]{i, m.get(i)});
            }
        }
        return list;
    }
}
