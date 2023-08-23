package Q20008_몬스터를_처치하자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, HP, arr[], time[], damage[], ans = 987654321;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        HP = Integer.parseInt(stk.nextToken());
        damage = new int[N];
        time = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(stk.nextToken());
            damage[i] = Integer.parseInt(stk.nextToken());
        }
    }

    private static void solve(int cnt, int hp) {
        if (hp <= 0) {
            ans = Math.min(ans, cnt);
            return;
        }

        boolean check = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= cnt) {
                check = true;
                int tmp = arr[i];
                arr[i] = cnt + time[i];
                solve(cnt + 1, hp - damage[i]);
                arr[i] = tmp;
            }
        }
        if (!check) solve(cnt + 1, hp);
    }

    private static void output() {
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(0, HP);
        output();
    }
}
