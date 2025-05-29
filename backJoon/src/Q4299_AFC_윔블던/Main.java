package Q4299_AFC_윔블던;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if (a < b)
            System.out.println("-1");
        else {
            int x = (a + b) / 2, y = (a - b) / 2;
            if (x + y == a && x - y == b)
                System.out.println(x + " " + y);
            else
                System.out.println("-1");
        }
    }
}