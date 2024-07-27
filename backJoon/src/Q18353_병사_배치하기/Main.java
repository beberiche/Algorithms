package Q18353_병사_배치하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int num = Integer.parseInt(stk.nextToken());

        list.add(num);
        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(stk.nextToken());
            if (list.get(list.size() - 1) > num) {
                list.add(num);
            } else {
                int idx = binarySearch(list, num);
                list.set(idx, num);
            }
        }

        System.out.println(N - list.size());
    }

    private static int binarySearch(List<Integer> list, int num) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
