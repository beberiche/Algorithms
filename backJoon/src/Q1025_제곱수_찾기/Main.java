package Q1025_제곱수_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> arr = Arrays.asList(0, 1, 4, 9, 6, 5);
        long answer = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arr.contains(a[i][j])) continue;

                if (a[i][j] == 0 || a[i][j] == 1 || a[i][j] == 4 || a[i][j] == 9) {
                    answer = Math.max(answer, a[i][j]);
                }

                for (int r = -N; r < N; r++) {
                    for (int c = -M; c < M; c++) {
                        if (r == 0 && c == 0) continue;

                        StringBuilder sb = new StringBuilder();
                        sb.append(a[i][j]);
                        int nr = i + r;
                        int nc = j + c;
                        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            sb.append(a[nr][nc]);

                            long num = Long.parseLong(new StringBuilder(sb).reverse().toString());
                            if (answer < num && checkPerfectSquareNumber(num)) {
                                answer = num;
                            }

                            nr += r;
                            nc += c;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean checkPerfectSquareNumber(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
