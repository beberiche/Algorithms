package Q14725_개미굴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 정렬 체계를 위한 treeMap 생성
// 루트 treeMap을 기준으로, 자식 treeMap, 자식의 자식 treeMap 생성 반복 진행
// 최종적으로 노드 연결에 대한 출력 값 생성
public class Main {
    static class Node {
        TreeMap<String, Node> tm;
        String val;
        int end;

        public Node(String val, int end) {
            this.val = val;
            this.end = end;
            this.tm = new TreeMap<>();
        }
    }


    private static void search(Node node, int idx) {
        if (idx == len) {
            return;
        }
        String tmp = stk.nextToken();
        if (!node.tm.containsKey(tmp)) {
            Node c_node = new Node(tmp, idx);
            node.tm.put(tmp, c_node);
        }
        search(node.tm.get(tmp), idx + 1);
    }

    static int len;
    static StringBuilder sb = new StringBuilder();

    static TreeMap<String, Node> rootMap = new TreeMap<>();
    static StringTokenizer stk;

    private static void go(Node node) {
        for (int i = 0; i < node.end; i++) {
            sb.append("--");
        }
        sb.append(node.val).append("\n");
        for (String key : node.tm.keySet()) {
            go(node.tm.get(key));
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            len = Integer.parseInt(stk.nextToken());
            String tmp = stk.nextToken();
            if (!rootMap.containsKey(tmp)) {
                Node node = new Node(tmp, 0);
                rootMap.put(tmp, node);
            }
            search(rootMap.get(tmp), 1);
        }
    }

    private static void solve() {
        for (String key : rootMap.keySet()) {
            go(rootMap.get(key));
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
