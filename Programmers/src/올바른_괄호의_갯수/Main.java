package 올바른_괄호의_갯수;

// dp[n] => dp[0] ~ dp[n-1] 까지의 수 중 2개의 조합 * 2
// 단 중복의 경우가 존재함. dp[4] => 0,4 / 1,3 / |2,2| => 자신과 자신을 곱해서 더해주자.
class Solution {
    int[] dp;
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n<=1) return dp[n];

        for(int i=2; i<=n; i++) {
            int st = 0;
            int ed = i-1;
            int ret = 0;
            while(st<ed) ret += (dp[st++]*dp[ed--])*2;
            if(st==ed) ret += dp[st]*dp[ed];
            dp[i] = ret;
        }

        return dp[n];
    }
}