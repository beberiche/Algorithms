package Q34556_MBTI_소개팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] score;
    private static int[] man;
    private static int[] woman;
    private static boolean[] visited;
    private static int N;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        man = new int[N];
        woman = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            man[i] = makeBit(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            woman[i] = makeBit(br.readLine());
        }

        score = new int[N][N];
        cal();
        perm(0, 0);
        System.out.println(max);
    }

    private static int makeBit(String mbti) {
        int m = (mbti.charAt(0) == 'I') ? 1 : 0;
        int b = (mbti.charAt(1) == 'N') ? 1 : 0;
        int t = (mbti.charAt(2) == 'F') ? 1 : 0;
        int i = (mbti.charAt(3) == 'P') ? 1 : 0;

        return m << 3 | b << 2 | t << 1 | i;
    }

    private static void perm(int depth, int sum) {
        if (depth >= N) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(depth + 1, sum + score[depth][i]);
            visited[i] = false;
        }
    }

    private static void cal() {
        for (int i = 0; i < man.length; i++) {
            for (int j = 0; j < woman.length; j++) {
                score[i][j] = Integer.bitCount(man[i] ^ woman[j]);
            }
        }
    }
}
