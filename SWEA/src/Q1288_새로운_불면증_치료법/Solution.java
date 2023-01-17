package Q1288_새로운_불면증_치료법;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int N, cnt, visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int cnt, flag, end = (1 << 10) - 1;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            visited = 0;
            cnt = 0;
            while (visited < end) {
                cnt += N;
                int tmp = cnt;
                while (tmp != 0) {
                    visited |= 1 << tmp % 10;
                    tmp /= 10;
                }
            }
            sb.append("#").append(t + " ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
