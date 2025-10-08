package Q1747_소수_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int max = 1005_000;

        int[] a = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            a[i] = i;
        }


        for (int i = 2; i <= max; i++) {
            if (a[i] == i) {
                for (int j = i + i; j <= max; j += i) {
                    a[j] = i;
                }
            }
        }
        a[0] = a[1] = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = N; i <= max; i++) {
            if (a[i] == i && p(String.valueOf(i))) {
                System.out.print(i);
                break;
            }
        }
    }

    private static boolean p(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
