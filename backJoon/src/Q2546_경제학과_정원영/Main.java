package Q2546_경제학과_정원영;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] cIQs = new int[n];
            double cSum = 0;
            double eSum = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cIQs[j] = Integer.parseInt(st.nextToken());
                cSum += cIQs[j];
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                eSum += Integer.parseInt(st.nextToken());
            }

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (cIQs[j] < cSum / n && cIQs[j] > eSum / m) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}