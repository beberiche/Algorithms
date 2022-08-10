package 정수_삼각형;

public class Solution {
    public static int solution(int[][] triangle) {
        int answer = 0;

        int len = triangle.length;

        int[][] dp = new int[len][len];

        dp[0][0] = triangle[0][0];
        for(int i=1; i<len; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    int num = triangle[i][j];
                    int comp1 = dp[i-1][j-1] + num;
                    int comp2 = dp[i-1][j] + num;
                    dp[i][j] = Math.max(comp1, comp2);
                }
                answer = Math.max(dp[i][j], answer);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
//        [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
        System.out.println(solution(new int[][] {{7},{3,8},{8,1,0},{2,7,4,4}, {4,5,2,6,5}}));
    }
}

