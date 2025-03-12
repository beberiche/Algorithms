package Q2704_이진법_시계;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String [] clock = br.readLine().split(":");

            int hour = Integer.parseInt(clock[0]);
            int minute = Integer.parseInt(clock[1]);
            int second = Integer.parseInt(clock[2]);

            String [] timeToBite = {
                    String.format("%6s", Integer.toBinaryString(hour)).replace(' ', '0'),
                    String.format("%6s", Integer.toBinaryString(minute)).replace(' ', '0'),
                    String.format("%6s", Integer.toBinaryString(second)).replace(' ', '0')
            };

            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    sb.append(timeToBite[k].charAt(j));
                }
            }

            sb.append(" ");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    sb.append(timeToBite[j].charAt(k));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
