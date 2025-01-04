package Q1942_디지털시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            int count = 0;

            String line = br.readLine();
            String[] times = line.split(" ");
            int t1 = timeToSeconds(times[0]);
            int t2 = timeToSeconds(times[1]);

            while(true) {
                if(timeToInt(t1) % 3 == 0) {
                    count++;
                }
                if(t1 == t2) {
                    break;
                }
                t1++;
                t1 %= (3600 * 24);
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    private static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hour * 3600 + minute * 60 + seconds;
    }

    private static int timeToInt(int time) {
        int[] list = new int[3];
        int cur = time;

        for(int i = 0; i < 3; i++) {
            list[i] = cur % 60;
            cur /= 60;
        }

        return list[2] * 10000 + list[1] * 100 + list[0];
    }
}
