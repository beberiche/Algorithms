package Q26069_붙임성_좋은_총총이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> s = new HashSet<>();
        s.add("ChongChong");
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String s1 = stk.nextToken();
            String s2 = stk.nextToken();

            if(s.contains(s1) || s.contains(s2)){
                s.add(s1);
                s.add(s2);
            }
        }
        System.out.println(s.size());
    }
}
