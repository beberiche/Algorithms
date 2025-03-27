package Q2857_FBI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next();
        }
        boolean isExist = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i].contains("FBI")) {
                System.out.print(i + 1 + " ");
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("HE GOT AWAY!");
        }
    }
}
