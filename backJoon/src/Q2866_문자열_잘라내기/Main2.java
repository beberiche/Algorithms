package Q2866_문자열_잘라내기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {
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

    private static boolean binarySearch(int mid) {
        Set str_set = new HashSet();
        for(int i=0; i<M; i++) {
            String str = str_arr[i].substring(mid);
            if(str_set.contains(str)) return true;
            str_set.add(str);
        }
        return false;
    }

    private static void go() {
        int l = 0;
        int r = N-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(binarySearch(mid)) {
                ans = mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
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
