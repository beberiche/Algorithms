package Q2921_도미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= i*2; j++) {
                ans += j;
            }
        }
        System.out.println(ans);
    }
}
