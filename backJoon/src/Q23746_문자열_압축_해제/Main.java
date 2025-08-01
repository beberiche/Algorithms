package Q23746_문자열_압축_해제;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = br.readLine();
        }

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(tmp[i]);
            String to = stk.nextToken();
            String from = stk.nextToken();
            str = str.replaceAll(from, to);
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());
        System.out.println(str.substring(s-1, e));
    }
}
