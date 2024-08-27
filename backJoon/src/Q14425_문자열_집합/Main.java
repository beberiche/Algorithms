package Q14425_문자열_집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Set<String> s = new HashSet<>();
        for(int i=0; i<N; i++) {
            s.add(br.readLine());
        }

        int cnt = 0;
        for(int i=0; i<M; i++) {
            if(s.contains(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
