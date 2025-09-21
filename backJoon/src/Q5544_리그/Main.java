package Q5544_리그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] total = new int[N];
        int[] value = new int[N];
        int game = N * (N - 1) / 2;

        int[][] teams = new int[N][2];

        int t1, t2, s1, s2;
        for (int i = 0; i < game; i++) {
            st = new StringTokenizer(br.readLine());
            t1 = Integer.parseInt(st.nextToken()) - 1;
            t2 = Integer.parseInt(st.nextToken()) - 1;
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());

            if (s1 > s2)
                total[t1] += 3;
            else if (s1 < s2)
                total[t2] += 3;
            else {
                total[t1] += 1;
                total[t2] += 1;
            }
        }

        for (int i = 0; i < N; i++) {
            teams[i][0] = i;
            teams[i][1] = total[i];
        }

        Arrays.sort(teams, (a, b) -> b[1] - a[1]);

        value[teams[0][0]] = 1;
        int vl = 1;
        int sc = teams[0][1];
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (teams[i][1] != sc) {
                if (count == 0)
                    count = 1;
                value[teams[i][0]] = vl + count;
                vl += count;
                count = 0;
                sc = teams[i][1];
            }
            if (teams[i][1] == sc) {
                value[teams[i][0]] = vl;
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(value[i]).append("\n");
        }
        System.out.print(sb);
    }
}
