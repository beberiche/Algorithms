package Q1235_학생_번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String a[] = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        int len = a[0].length();
        StringBuilder b[] = new StringBuilder[N];
        Set<String> s = new HashSet<>();
        int ans = -1;
        for (int i = 0; i < len; i++) {
            boolean check = true;
            for (int j = 0; j < N; j++) {
                b[j] = new StringBuilder().append(a[j].charAt(len - 1 - i)).append(b[j] == null ? "" : b[j]);

                if (s.contains(b[j].toString())) {
                    check = false;
                } else {
                    s.add(b[j].toString());
                }
            }

            if (check) {
                ans = i;
                break;
            }
        }

        System.out.println(ans+1);
    }
}
