package Q9082_지뢰찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 0인경우 0,0;
// 1인경우 0,1 혹은 1,0;
// 2인경우 1,1;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, boom[], ans;
    static String str1, str2;

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        str1 = br.readLine();
        str2 = br.readLine();
        boom = new int[N];
    }

    private static int go(int cnt) {
        for (int i = 1; i < N - 1; i++) {
            int curr = str1.charAt(i) - '0';
            if (boom[i - 1] + boom[i] > curr) return -100;
            else if (boom[i - 1] + boom[i] == curr) boom[i + 1] = 0;
            else if (boom[i - 1] + boom[i] < curr) {
                boom[i + 1] = 1;
                cnt++;
            }
        }
        if (boom[N - 2] + boom[N - 1] != str1.charAt(N - 1) - '0') return -100;
        return cnt;
    }

    private static void solve() {
        int fir = str1.charAt(0) - '0';
        ans = 0;
        if (fir == 2) {
            boom[0] = 1;
            boom[1] = 1;
            ans = go(2);
        } else if (fir == 1) {
            boom[0] = 1;
            boom[1] = 0;
            int ret1 = go(1);
            boom[0] = 0;
            boom[1] = 1;
            int ret2 = go(1);
            ans = Math.max(ret1, ret2);
        } else {
            ans = go(0);
        }
    }

    private static void output() {
        sb.append(ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            input();
            solve();
            output();
        }
        System.out.print(sb.toString());
    }
}
