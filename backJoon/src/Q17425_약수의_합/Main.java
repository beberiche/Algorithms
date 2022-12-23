package Q17425_약수의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[1000001];
        long[] dp = new long[1000001];
        Arrays.fill(arr, 1);
        dp[1] = 1;
        for(int i=2; i<=1000000; i++) {
            for(int j=i; j<=1000000; j+=i) if(j%i==0) arr[j]+=i;
            dp[i]=dp[i-1]+arr[i];
        }
        StringBuilder sb = new StringBuilder();
        while(--T>=0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        System.out.println(sb.toString());
    }
}
