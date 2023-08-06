package Q18119_단어_암기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  비트마스킹
//  string |= 1 << (int)c-'a';
//  현재 기억하는 애로 임의의 글자를 기억할 수 있는지 확인하는 법 -> 글자 & 기억하는 문자들 = 글자인경우;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer stk;
    static int N, M, memory, bit[];

    private static void input() throws Exception {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        bit = new int[N];
        memory = (1 << 26) - 1;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                bit[i] |= 1 << tmp.charAt(j) - 'a';
            }
        }
    }

    private static void solve() throws Exception {
        while (--M >= 0) {
            stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            char ch = stk.nextToken().charAt(0);
            int ret = 0;
            memory = num == 1 ? memory ^ (1 << ch - 'a') : memory | (1 << ch - 'a');
            for (int i = 0; i < N; i++) {
                if ((bit[i] & memory) == bit[i]) ret++;
            }
            ans.append(ret).append("\n");
        }
    }

    private static void output() {
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
