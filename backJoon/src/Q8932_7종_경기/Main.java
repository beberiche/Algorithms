package Q8932_7종_경기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[7];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 7; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sum += (int) ((9.23076) * Math.pow((26.7 - arr[0]), 1.835));
            sum += (int) ((1.84523) * Math.pow((arr[1] - 75), 1.348));
            sum += (int) ((56.0211) * Math.pow((arr[2] - 1.5), 1.05));
            sum += (int) ((4.99087) * Math.pow((42.5 - arr[3]), 1.81));
            sum += (int) ((0.188807) * Math.pow((arr[4] - 210), 1.41));
            sum += (int) ((15.9803) * Math.pow((arr[5] - 3.8), 1.04));
            sum += (int) ((0.11193) * Math.pow((254 - arr[6]), 1.88));

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
