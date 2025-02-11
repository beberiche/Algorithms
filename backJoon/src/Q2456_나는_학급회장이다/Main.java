package Q2456_나는_학급회장이다;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] candidate = new int[3];
        int[] squared = new int[3];

        int N = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            candidate[0] += a;
            candidate[1] += b;
            candidate[2] += c;

            squared[0] += a * a;
            squared[1] += b * b;
            squared[2] += c * c;
        }

        int maxScore = Math.max(candidate[0], Math.max(candidate[1], candidate[2]));

        if(countOccurrences(candidate, maxScore) == 1) {
            for(int i = 0; i < candidate.length; i++) {
                if(candidate[i] == maxScore) {
                    System.out.println((i + 1) + " " + maxScore);
                    break;
                }
            }
        } else {
            int maxSquared = Math.max(squared[0], Math.max(squared[1], squared[2]));
            int elected = -1;

            for(int i = 0; i < squared.length; i++) {
                if(squared[i] == maxSquared) {
                    elected = i;
                    break;
                }
            }

            if(countOccurrences(squared, maxSquared) > 1) {
                System.out.println("0 " + candidate[elected]);
            } else {
                System.out.println((elected + 1) + " " + candidate[elected]);
            }
        }
        sc.close();
    }

    private static int countOccurrences(int[] array, int value) {
        int count = 0;
        for(int v : array) {
            if(v == value) {
                count++;
            }
        }
        return count;
    }
}