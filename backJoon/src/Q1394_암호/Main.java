package Q1394_암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pwd = br.readLine();

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 각 문자에 대해 인덱스를 저장.
            // 단, 중복된 문자가 존재하는 경우에는 더 앞선 인덱스만 저장하도록 함.
            // -> 문제에 가장 빠른 걸 찾는 건 내용은 없어서 아마 중복된 문자는 없을 것으로 봄.
            m.putIfAbsent(str.charAt(i), i + 1);
        }
        // pwd의 각 갯수의 값
        // prev: 이전까지의 암호 횟수
        // length: 문자열 길이 길이
        // n: 계층
        // idx: 현재 보고있는 문자의 인덱스
        // prev + length^n + idx
        // 매번 ^n을 구하는 것은 비효율적이므로,
        // pwd 탐색 시 지속적으로 length를 곱해준다.

        final int MOD = (int) (1e5 * 9 + 528);
        int[] dp = new int[pwd.length() + 1];
        for (int i = 1; i <= pwd.length(); i++) {
            char c = pwd.charAt(i - 1);
            if (!m.containsKey(c)) {
                // pw에 존재하는 문자가 str에 없으면, 암호는 풀 수 없음.
                break;
            }
            dp[i] = dp[i - 1] * str.length() + m.get(c);
            dp[i] %= MOD;
        }
        System.out.println(dp[pwd.length()]);
    }
}
