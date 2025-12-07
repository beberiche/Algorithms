package Q9329_패스트_푸드_상금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            int[][] prizes = new int[N][100];
            int[] stickers = new int[M + 1];

            for (int j = 0; j < N; j++) {
                stk = new StringTokenizer(br.readLine());
                prizes[j][0] = Integer.parseInt(stk.nextToken());
                for (int z = 1; z <= prizes[j][0] + 1; z++) {
                    prizes[j][z] = Integer.parseInt(stk.nextToken());
                }
            }
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                stickers[j] = Integer.parseInt(stk.nextToken());
            }

            int result = 0;
            for (int j = 0; j < N; j++) {
                int min = 987654321;
                for (int z = 1; z <= prizes[j][0]; z++) {
                    if (stickers[prizes[j][z] - 1] < min) {
                        min = stickers[prizes[j][z] - 1];
                    }
                }
                result += prizes[j][prizes[j][0] + 1] * min;

            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
