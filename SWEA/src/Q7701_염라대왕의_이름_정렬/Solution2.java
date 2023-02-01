package Q7701_염라대왕의_이름_정렬;

import java.io.*;
import java.util.*;
public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ").append("\n");
            int N = Integer.parseInt(br.readLine());

            Set<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int r = o1.length() - o2.length();
                    if (r == 0)
                        return o1.compareTo(o2);
                    else
                        return r;
                }
            });

            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }

            for (String string : set) {
                sb.append(string).append("\n");
            }
        }
        System.out.print(sb);
    }
}