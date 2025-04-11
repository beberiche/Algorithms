package Q2948_2009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate baseDt = LocalDate.of(2009, 1, 1);
        String day[] = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        LocalDate inputDt = LocalDate.of(2009, M, D);
        int diff = (int) (inputDt.toEpochDay() - baseDt.toEpochDay());

        System.out.println(day[diff % 7]);
    }
}
