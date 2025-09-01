package Q5543_상근날드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hamburgerMin = Integer.MAX_VALUE;
        int drinkMin = Integer.MAX_VALUE;

        int hamburgerCount = 3;
        int drinkCount = 2;
        for (int i = 0; i < hamburgerCount; i++) {
            hamburgerMin = Math.min(hamburgerMin, Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < drinkCount; i++) {
            drinkMin = Math.min(drinkMin, Integer.parseInt(br.readLine()));
        }

        System.out.println(hamburgerMin + drinkMin - 50);
    }
}
