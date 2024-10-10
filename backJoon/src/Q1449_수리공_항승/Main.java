package Q1449_수리공_항승;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);

        int curr = a[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            int next = a[i];
            if (next - curr  >= L) {
                curr = next;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
