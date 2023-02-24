package Q17951_흩날리는_시험지_속에서_내_평점이_느껴진거야;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;
    static int N,K,l,r,arr[],min;
    private static void input() throws Exception{
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            r+=arr[i];
        }

    }
    private static void solve() {
        while(l<=r) {
            int mid = (l+r)/2;
            if(check(mid)) {
                min = mid;
                l= mid+1;
            } else {
                r = mid-1;
            }
        }
    }

    private static boolean check(int num) {
        int sum =0;
        int cnt =0;
        for(int i=0; i<N; i++) {
            sum +=arr[i];
            if(sum >=num) {
                cnt++;
                sum = 0;
            }
        }
        return cnt >= K;
    }

    private static void output() {
        System.out.println(min);
    }
    public static void main(String[] args) throws Exception{
        input();
        solve();
        output();
    }
}

