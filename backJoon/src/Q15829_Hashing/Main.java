package Q15829_Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long ans = 0;
        long pow = 1;
        long mod = 1234567891;
        for(int i=0; i<N; i++) {
            ans+=((str.charAt(i)-'a'+1)*pow)%mod;
            pow = (pow*31)%mod;
        }
        System.out.println(ans%mod);
    }
}
