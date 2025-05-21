package Q3595_맥주_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0, c = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i * i * i <= n; i++) {
            if (n % i == 0) {
                for (int j = i; j * j <= n / i; j++) {
                    if (n / i % j == 0) {
                        int k = n / i / j, val = i * j + j * k + i * k;
                        if (min > val) {
                            min = val;
                            a = i;
                            b = j;
                            c = k;
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d %d", a, b, c);
    }
}
