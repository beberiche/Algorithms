package Q1822_차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] a = new int[N];
        int[] b = new int[M];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int target = a[i];

            int l = 0;
            int r = M;

            while (l < r) {
                int mid = (l + r) >> 1;
                if (target <= b[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (r >= M || b[r] != target) {
                list.add(target);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int num : list) {
            sb.append(num).append(" ");
        }

        System.out.print(sb);
    }
}
