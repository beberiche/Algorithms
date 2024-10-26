package Q1075_나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N /= 100;
        N *= 100;
        int ret = 0;
        while ((N + ret) % F != 0 && ret < 100) ret++;

        if(ret < 10) System.out.printf("0%d", ret);
        else System.out.printf("%d", ret);
    }
}
