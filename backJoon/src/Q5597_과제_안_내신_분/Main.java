package Q5597_과제_안_내신_분;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[29];
        int[] countArr = new int[31];
        for(int i=1; i<arr.length; i++) {
           countArr[sc.nextInt()]++;
        }

        for(int i=1; i<countArr.length; i++) {
            if(countArr[i] <= 0) {
                System.out.println(i);
            }
        }
    }
}
