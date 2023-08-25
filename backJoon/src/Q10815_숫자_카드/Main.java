package Q10815_숫자_카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];

    private static boolean go(int num) {
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == num) return true;
            else if (arr[mid] > num) r = mid - 1;
            else l = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stk.nextToken());
            sb.append(go(num) ? 1 : 0).append(" ");
        }

        System.out.print(sb.toString());
    }
}
