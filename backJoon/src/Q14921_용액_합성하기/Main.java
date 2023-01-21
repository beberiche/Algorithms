package Q14921_용액_합성하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int ans = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stk.nextToken());
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int val = arr[l] + arr[r];
            if(Math.abs(ans) > Math.abs(val)) ans = val;
            if (val == 0) break;
            else if (val > 0) r--;
            else l++;
        }

        System.out.println(ans);
    }
}
