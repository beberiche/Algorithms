package Q11568_민균이의_계략;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        list.add(Integer.parseInt(stk.nextToken()));

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int idx = binarySearch(num);
                list.set(idx, num);
            }
        }
        System.out.println(list.size());

    }

    private static int binarySearch(int num) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
