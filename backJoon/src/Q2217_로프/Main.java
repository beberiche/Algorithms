package Q2217_로프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = arr[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            ans = Math.max(arr[i] * (N - i), ans);
        }

        System.out.println(ans);
    }
}
