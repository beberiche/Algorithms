package Q1241_머리_톡톡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            len = Math.max(len, a[i]);
        }

        int[] cnt = new int[len + 1];
        for (int i = 0; i < N; i++) {
            cnt[a[i]]++;
        }


        int[] ret = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (cnt[i] == 0) continue;
            for (int j = i; j <= len; j += i) {
                ret[j] += cnt[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(ret[num] - 1).append("\n");
        }

        System.out.print(sb);
    }
}
