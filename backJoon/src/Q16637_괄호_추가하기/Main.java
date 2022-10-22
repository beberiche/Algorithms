package Q16637_괄호_추가하기;


import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static char[] oper;
    static int ans = -987654321;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        char[] arr = sc.next().toCharArray();
        num = new int[N - N/2];
        oper = new char[N/2];

        int nIdx = 0;
        int oIdx = 0;
        for(int i=0; i<N; i++) {
            if(i%2 ==0) num[nIdx++] = arr[i]-'0';
            else oper[oIdx++] = arr[i];
        }

        recur(0, num[0]);

        System.out.println(ans);
    };

    private static void recur(int idx, int sum) {
        if(idx == N/2) {
            ans = Math.max(ans, sum);
            return;
        }

        recur(idx+1, cal(sum, oper[idx] ,num[idx+1]));

        if(idx+2 <= N/2) {
            int nextSum = cal(num[idx+1],oper[idx+1],num[idx+2]);
            int prevSum = cal(sum, oper[idx] , nextSum);
            recur(idx+2, prevSum);
        }
    }

    private static int cal(int prev, char oper, int next) {
        if (oper == '+') return prev+next;
        else if (oper == '-') return prev-next;
        else return prev*next;
    }
}
