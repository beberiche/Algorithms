package Q1418_K_세준수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] maxPrimeFactor = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            maxPrimeFactor[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (maxPrimeFactor[i] == i) {
                for (int j = i; j <= N; j += i) {
                    maxPrimeFactor[j] = i;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPrimeFactor[i] <= K) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
