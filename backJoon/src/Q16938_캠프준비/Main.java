package Q16938_캠프준비;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N,L,R,X;
    static int[] plbms;
    static boolean[] visited;
    static int ans =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();

        plbms = new int[N];
        for(int i=0; i<N; i++) plbms[i] = sc.nextInt();
        Arrays.sort(plbms);
        visited = new boolean[N];

        powerSet(0);
        System.out.println(ans);
    }

    public static void powerSet(int cnt) {
        if(cnt>=N) {
            List<Integer> sel = new ArrayList<>();
            for(int i=0; i<N; i++) {
                if(visited[i]) sel.add(plbms[i]);
            }
            if(sel.size() <= 1) return;

            if(sel.get(sel.size()-1)-sel.get(0) < X) return;

            int total = sum(sel);
            if(total<L || total>R) return;

            ans++;
            return;
        }

        visited[cnt] = true;
        powerSet(cnt + 1);
        visited[cnt] = false;
        powerSet(cnt + 1);
    }

    public static int sum(List<Integer> sel) {
        int result = 0;
        for(Integer n : sel) result += n;
        return result;
    }
}
