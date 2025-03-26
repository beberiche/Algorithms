package Q2846_오르막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                sum += arr[i + 1] - arr[i];
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        max = Math.max(max, sum);
        System.out.println(max);
    }
}
