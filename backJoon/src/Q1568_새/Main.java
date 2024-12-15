package Q1568_새;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ret = 0;
        while (N != 0) {
            int cnt = 1;
            while (cnt <= N) {
                N -= cnt++;
            }
            ret += cnt-1;
        }
        System.out.println(ret);
    }
}
