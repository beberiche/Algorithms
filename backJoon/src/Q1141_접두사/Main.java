package Q1141_접두사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        Arrays.sort(a, (s1, s2) -> s2.length() - s1.length());

        List<String> list = new ArrayList<>();
        list.add(a[0]);
        for (int i = 1; i < N; i++) {
            boolean flag = false;
            for (String s : list) {
                if (check(s, a[i])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(a[i]);
            }
        }
        System.out.println(list.size());
    }

    private static boolean check(String s1, String s2) {
        for(int i=0; i<s2.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1!=c2) return false;
        }
        return true;
    }
}
