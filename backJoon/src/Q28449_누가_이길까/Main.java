package Q28449_누가_이길까;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] hi = new int[N];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hi[i] = Integer.parseInt(stk.nextToken());
        }

        int[] arc = new int[M];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arc[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arc);

        long win = 0;
        long lose = 0;
        long draw = 0;

        for (int i = 0; i < N; i++) {
            int left = binarySearchLeft(hi[i], arc);
            int right = binarySearchRight(hi[i], arc);

            win += left;
            draw += (right - left + 1);
            lose += (M - right - 1);
        }
        System.out.print(win + " " + lose + " " + draw);
    }


    private static int binarySearchLeft(int target, int[] arc) {
        int l = 0;
        int r = arc.length - 1;

        int ret = arc.length;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arc[mid] >= target) {
                ret = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ret;
    }

    private static int binarySearchRight(int target, int[] arc) {
        int l = 0;
        int r = arc.length - 1;

        int ret = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arc[mid] <= target) {
                ret = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ret;
    }
}

