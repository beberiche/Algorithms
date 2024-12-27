package Q1834_나머지와_몫이_같은_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        for (int i = 1; i < N; i++) {
            sum += (N * i) + i;
        }

        System.out.println(sum);
    }
}
