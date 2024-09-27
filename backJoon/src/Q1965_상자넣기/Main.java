package Q1965_상자넣기;

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
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= num) {
                right--;
            } else {
                left++;
            }
        }
        return right;
    }
}
