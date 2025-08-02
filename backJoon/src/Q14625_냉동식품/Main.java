package Q14625_냉동식품;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int startHour = Integer.parseInt(stk.nextToken());
        int startMinute = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int endHour = Integer.parseInt(stk.nextToken());
        int endMinute = Integer.parseInt(stk.nextToken());

        int numN = Integer.parseInt(br.readLine());

        int hour = startHour;
        int minutes = startMinute;
        int count = 0;

        while (true) {
            String str = String.valueOf(numN);

            String changeHour = String.valueOf(hour);
            String changeMinutes = String.valueOf(minutes);

            if (changeHour.length() == 1) {
                changeHour = "0" + changeHour;
            }

            if (changeMinutes.length() == 1) {
                changeMinutes = "0" + changeMinutes;
            }

            if (changeHour.contains(str) || changeMinutes.contains(str)) {
                count++;
            }

            if (hour == endHour && minutes == endMinute) {
                break;
            }

            minutes++;

            if (minutes == 60) {
                hour++;
                minutes = 0;
            }

            if (hour == 24) {
                hour = 0;
            }
        }
        System.out.println(count);
    }
}