package Q3041_N_퍼즐;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int PUZZLE_INDEX = 4;
        int answer = 0;

        for (int i = 0; i < PUZZLE_INDEX; i++) {
            String input = br.readLine();

            for (int j = 0; j < PUZZLE_INDEX; j++) {
                char current = input.charAt(j);

                if(current == '.') continue;

                int number = current - 'A';
                int x = number / 4;
                int y = number % 4;
                answer += Math.abs(i - x) + Math.abs(j - y);
            }
        }

        System.out.println(answer);
    }
}
