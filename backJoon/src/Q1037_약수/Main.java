package Q1037_약수;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        int cnt = N;
        while(--cnt>=0) {
            list.add(sc.nextInt());
        }
        list.sort(Comparator.naturalOrder());
        long ans = list.size() == 1 ? (long) Math.pow(list.get(0),2) :  list.get(0) * list.get(list.size()-1);
        System.out.println(ans);
    }
}
