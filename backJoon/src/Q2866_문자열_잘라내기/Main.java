package Q2866_문자열_잘라내기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static char arr[][];
    static String str_arr[];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    private static void toVertical() {
        str_arr = new String[M];
        for (int i = 0; i < M; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j < N; j++) {
                sb.append(arr[j][i]);
            }
            str_arr[i] = sb.toString();
        }
    }

    private static void go() {
        for (int i = 0; i < str_arr[0].length(); i++) {
            Set str_set = new HashSet();
            for (int j = 0; j < M; j++) {
                String str = str_arr[j].substring(i);
                if (str_set.contains(str)) return;
                str_set.add(str);
            }
            ans++;
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        toVertical();
        go();
        output();
    }
}
