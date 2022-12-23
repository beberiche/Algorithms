package Q6588_골드바흐의_추측;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] primeN = new boolean[INF + 1];
        primeN[0] = true;
        primeN[1] = true;
        for (int i = 2; i <= INF; i++) {
            if(!primeN[i]) {
                for (int j = i + i; j <= INF; j += i) {
                    if (primeN[j]) continue;
                    if (j % i == 0) primeN[j] = true;
                }
            }
        }
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            outer:
            for (int i = 2; i <= N; i++) {
                if(!primeN[i] && !primeN[N-i]) {
                    bw.write(N + " = " + i + " " + "+" + " " + (N-i));
                    bw.append("\n");
                    break outer;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
