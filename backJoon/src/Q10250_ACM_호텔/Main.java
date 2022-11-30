package Q10250_ACM_호텔;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(--T>=0) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int[][] arr = new int[H+1][W+1];
            outer :for(int w=1; w<=W; w++) {
                for(int h=1; h<=H;h++) {
                    if(N==1) {
                        if(w < 10) {
                            System.out.println(h + "0" + w);
                        } else {
                            System.out.println(h + "" + w);
                        }
                        break outer;
                    } else {
                        N--;
                    }
                }
            }

        }
    }
}
