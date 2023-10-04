package Q16472_고냥이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// l,r 모두 0부터 시작
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int l = 0;
        int r = 0;
        int[] visited = new int[26];
        visited[str.charAt(0) - 'a']++;
        int ans = 0;
        int cnt = 1;
        while (l <= r) {
            if (cnt <= N) {
                ans = Math.max(ans, r - l + 1);
                r++;
                if (r == str.length()) break;
                if (visited[str.charAt(r) - 'a'] == 0) cnt++;
                visited[str.charAt(r) - 'a']++;
            } else {
                visited[str.charAt(l) - 'a']--;
                if (visited[str.charAt(l) - 'a'] == 0) cnt--;
                l++;
            }
        }
        System.out.println(ans);
    }
}
