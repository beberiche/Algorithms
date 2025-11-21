package Q10101_삼각형_외우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (isEquilateral(a, b, c)) {
            System.out.println("Equilateral");
            return;
        }

        if (isIsosceles(a, b, c)) {
            System.out.println("Isosceles");
            return;
        }

        if (isScalene(a, b, c)) {
            System.out.println("Scalene");
            return;
        }

        System.out.println("Error");
    }

    private static boolean isScalene(int a, int b, int c) {
        if (a + b + c != 180) {
            return false;
        }
        if (a == b || b == c || c == a) {
            return false;
        }
        return true;
    }

    private static boolean isEquilateral(int a, int b, int c) {
        return a == 60 && b == 60 && c == 60;
    }

    private static boolean isIsosceles(int a, int b, int c) {
        if (a + b + c != 180) {
            return false;
        }
        if (a == b || b == c || c == a) {
            return true;
        }
        return false;
    }
}
