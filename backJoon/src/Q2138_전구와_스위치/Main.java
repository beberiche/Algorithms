package Q2138_전구와_스위치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[] copy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] chArr1 = br.readLine().toCharArray();
        copy = Arrays.copyOf(chArr1, chArr1.length);
        char[] chArr2 = br.readLine().toCharArray();


        int cnt1 = 0;
        int ans = 987654321;
        for (int i = 1; i < N; i++) {
            if (copy[i - 1] != chArr2[i - 1]) {
                go(i);
                cnt1++;
            }
        }

        if (copy[N - 1] == chArr2[N - 1]) {
            ans = cnt1;
        }

        int cnt2 = 1;
        copy = Arrays.copyOf(chArr1, chArr1.length);
        go(0);
        for (int i = 1; i < N; i++) {
            if (copy[i - 1] != chArr2[i - 1]) {
                go(i);
                cnt2++;
            }
        }

        if (copy[N - 1] == chArr2[N - 1]) {
            ans = Math.min(ans, cnt2);
        }

        System.out.println(ans == 987654321 ? -1 : ans);
    }

    private static void change(int idx) {
        copy[idx] = copy[idx] == '0' ? '1' : '0';
    }


    private static void go(int idx) {
        if (idx == 0) {
            change(idx + 1);
        } else if (idx == N - 1) {
            change(idx - 1);
        } else {
            change(idx - 1);
            change(idx + 1);
        }
        change(idx);
    }
}
