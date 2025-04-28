package Q3023_마술사_이민혁;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        char[][] resultArr = new char[r * 2][c * 2];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                resultArr[i][j] = arr[i][j];
                resultArr[i][c * 2 - j - 1] = arr[i][j];
                resultArr[r * 2 - i - 1][j] = arr[i][j];
                resultArr[r * 2 - i - 1][c * 2 - j - 1] = arr[i][j];
            }
        }

        stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken()) - 1;
        int b = Integer.parseInt(stk.nextToken()) - 1;

        resultArr[a][b] = resultArr[a][b] == '.' ? '#' : '.';

        StringBuilder sb = new StringBuilder(Arrays.deepToString(resultArr)
                .replace("[", "").replace(",", "").replace(" ", "").replace("]", "\n"));
        System.out.print(sb);
    }
}
