package Q16719_ZOAC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] text;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        text = br.readLine().toCharArray();
        visited = new boolean[text.length];
        // 맨처음에는, 정렬해서 사전 순으로 했을 때 문자를 찾는다.
        // 기존의 나온 문자가 있는 경우, 그 문자의 뒤에부분을 확인한다.
        // 만약 없다면 앞의 부분에 넣을 것들을 찾으면 된다.
        DFS(0, text.length);
    }

    private static void DFS(int st, int ed) {
        if(st >= ed) return;

        char[] copyArr = Arrays.copyOfRange(text, st,ed);
        Arrays.sort(copyArr);
        int idx = -1;
        for(int i=st; i<ed; i++) {
            if(text[i] == copyArr[0] && !visited[i]) {
                idx= i;
                break;
            }
        }
        if(idx == -1) return;

        visited[idx] = true;
        String ans = "";
        for(int i=0; i<text.length; i++) {
            if(visited[i]) ans += text[i];
        }
        System.out.println(ans);
        DFS(idx+1, ed);
        DFS(st,idx);
    }
}
