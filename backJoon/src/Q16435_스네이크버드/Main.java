package Q16435_스네이크버드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int H = Integer.parseInt(stk.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine());
        while(--N>=0) {
            pq.add(Integer.parseInt(stk.nextToken()));
        }

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if(curr <= H) H++;
            else break;
        }
        System.out.println(H);
    }
}
