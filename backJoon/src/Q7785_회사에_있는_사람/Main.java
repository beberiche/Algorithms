package Q7785_회사에_있는_사람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> s = new TreeSet<>((n1,n2)-> n2.compareTo(n1));
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String s1 = stk.nextToken();
            String s2 = stk.nextToken();

            if (s2.equals("enter")) {
                s.add(s1);
            } else {
                s.remove(s1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : s) {
            sb.append(str).append("\n");
        }
        System.out.print(sb.toString());
    }
}
