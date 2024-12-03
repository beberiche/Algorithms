package Q1251_단어_나누기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static PriorityQueue<String> pq = new PriorityQueue<>();
    private static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (int i = 1; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String s1 = go(0, i);
                String s2 = go(i, j);
                String s3 = go(j, str.length());
                pq.add(s1 + s2 + s3);
            }
        }
        System.out.println(pq.poll());
    }

    private static String go(int st, int ed) {
        return new StringBuilder(str.substring(st, ed)).reverse().toString();
    }
}
