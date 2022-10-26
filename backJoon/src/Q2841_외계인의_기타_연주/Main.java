package Q2841_외계인의_기타_연주;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer>[] sArr;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextInt();

        sArr = new Stack[7];

        for(int i=0; i<7; i++) sArr[i] = new Stack<>();

        cnt = 0;
        boolean check = false;
        while(--N>=0) {
            int g = sc.nextInt();
            int p = sc.nextInt();
            while(!sArr[g].isEmpty()) {
                if(sArr[g].peek() > p) pop(g);
                else break;
            }
            if(!check || sArr[g].isEmpty() ||sArr[g].peek() < p) push(g,p);
            if(!check) check = true;
        }
        System.out.println(cnt);
    }

    private static void pop(int g) {
        sArr[g].pop();
        cnt++;
    }
    private static void push(int g, int p) {
        sArr[g].push(p);
        cnt++;
    }
}
