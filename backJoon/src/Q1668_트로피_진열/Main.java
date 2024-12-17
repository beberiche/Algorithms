package Q1668_트로피_진열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int maxL = 0;
        int cntL = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (a[i] > maxL) {
                cntL++;
                maxL = a[i];
            }
        }

        int maxR = 0;
        int cntR = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] > maxR) {
                cntR++;
                maxR = a[i];
            }
        }
        System.out.println(cntL + "\n" + cntR);
    }
}
