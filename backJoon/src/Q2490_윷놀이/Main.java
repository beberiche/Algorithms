package Q2490_윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 3; j++) {
            int cnt = 0;

            String s = br.readLine();
            String[] split = s.split(" ");

            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("0")) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                System.out.println("E");
            } else if (cnt == 4) {
                System.out.println("D");
            } else if (cnt == 3) {
                System.out.println("C");
            } else if (cnt == 2) {
                System.out.println("B");
            } else if (cnt == 1) {
                System.out.println("A");
            }
        }
    }
}
