package Q10419_지각;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int earlyFinish = 0;

        for (int i = 0; i < num; i++) {
            int time = Integer.parseInt(br.readLine());
            int okLate = time;

            while (true) {
                earlyFinish = okLate * okLate;
                if (okLate + earlyFinish <= time) {
                    break;
                } else {
                    okLate--;
                }
            }
            sb.append(okLate).append("\n");
        }

        System.out.println(sb.toString());
    }
}
