package Q4913_페르마의_크리스마스_정리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // false -> 소수
        // true -> 소수 아님
        boolean[] primeN = new boolean[INF];
        primeN[0] = true;
        primeN[1] = true;
        for (int i = 2; i < INF; i++) {
            if (!primeN[i]) {
                for (int j = i + i; j < INF; j += i) {
                    if (primeN[j]) continue;
                    if (j % i == 0) primeN[j] = true;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());

            if (L == -1 && U == -1) break;

            int tempL = L<0 ? 0 : L;
            int tempU = U<0 ? 0 : U;
            int x = 0;
            int y = 0;


            for (int i = tempL; i <= tempU; i++) {
                if (!primeN[i]) {
                    if (i % 4 == 1 || i == 2) y++;
                    x++;
                }
            }

            bw.write(L + " " + U + " " + x + " " + y);
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
