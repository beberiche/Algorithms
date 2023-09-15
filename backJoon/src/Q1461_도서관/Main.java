package Q1461_도서관;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 음수, 양수 나누어서 계산
// 가장 긴 거리의 경우, 돌아오지 않아도 되므로 한번만 적용
// 나머지는 0까지 왕복하므로 *2 적용
public class Main {
    static int N, M;
    static List<Integer> neg, pos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        neg = new ArrayList<>();
        pos = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (num < 0) neg.add(num);
            else pos.add(num);
        }


        Collections.sort(neg);
        Collections.sort(pos, (n1, n2) -> n2 - n1);

        int dist = 0;
        for (int i = 0; i < neg.size(); i += M) {
            dist += neg.get(i) * 2 * -1;
        }

        for (int i = 0; i < pos.size(); i += M) {
            dist += pos.get(i) * 2;
        }


        System.out.println(dist - Math.max(neg.size() == 0 ? 0 : neg.get(0) * -1, pos.size() == 0 ? 0 : pos.get(0)));
    }
}
