package Q23843_콘센트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> pq1, pq2;
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 전자기기 개수, 콘센트 개수
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        // pq1 : 전자기기 내림차순
        // pq2 : 콘센트 오름차순
        pq1 = new PriorityQueue<>((n1,n2) -> n2-n1);
        pq2 = new PriorityQueue<>((n1,n2)-> n1-n2);
        Queue<Integer> q = new LinkedList<>();

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) pq1.add(Integer.parseInt(stk.nextToken()));

        charge();

        // 시작!
        int ans = 0;
        while(!pq2.isEmpty()) {
            int t = pq2.peek();

            // 시간만큼 감소
            while(!pq2.isEmpty()) {
                if(pq2.peek()-t == 0) pq2.poll();
                else q.add(pq2.poll()-t);
            }

            while(!q.isEmpty()) pq2.add(q.poll());

            ans +=t;

            charge();
        }
        System.out.println(ans);
    }

    private static void charge() {
        while(pq2.size() != M) {
            if(pq1.isEmpty()) break;
            pq2.add(pq1.poll());
        }
    }
}
