package Q1327_소트_게임;

import java.util.*;

public class Main {
    static String sortStr;
    static int N, K, L, R;
    static String prevStr, midStr, nextStr;

    static StringBuilder midSb;
    static class Node {
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    static Node curr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++) {
             str.append(sc.next());
        }
        char[] temp = str.toString().toCharArray();
        Arrays.sort(temp);
        sortStr = new String(temp);
        System.out.println(BFS(str.toString()));
    }

    private static int BFS(String st) {
        Queue<Node> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Node(st, 0));

        while (!q.isEmpty()) {
            curr = q.poll();

            if (sortStr.equals(curr.str)) {
                return curr.cnt;
            }

            if (set.contains(curr.str)) continue;
            set.add(curr.str);

            L = 0;
            R = K;
            while (R <= N) {
                prevStr = curr.str.substring(0,L);
                midStr = curr.str.substring(L, R);
                nextStr = curr.str.substring(R,N);
                midSb = new StringBuilder();
                for(int i=midStr.length()-1; i>=0; i--) midSb.append(midStr.charAt(i));

                q.add(new Node(prevStr+midSb.toString() +nextStr, curr.cnt + 1));
                L++;
                R++;
            }
        }

        return -1;
    }
}
