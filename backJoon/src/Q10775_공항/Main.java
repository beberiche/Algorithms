package Q10775_공항;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int G, P, p[], ans;

    private static int find(int n) {
        if (p[n] == n) {
            return n;
        }
        return p[n] = find(p[n]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        p = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            p[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int num = Integer.parseInt(br.readLine());

            int x = find(num);
            int y = find(num - 1);

            if (x == 0) break;
            else {
                ans++;
                p[x] = x != y ? y : x - 1;
            }
        }
        System.out.print(ans);
    }
}
