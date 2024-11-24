package Q1296_팀_이름_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] a = new int[] {'L'-'A', 'O'-'A', 'V'-'A', 'E'-'A'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nameCnt = new int[26];
        String name = br.readLine();
        nameCnt = countName(name);

        int N = Integer.parseInt(br.readLine());

        Node node = null;
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int[] teamNameCnt = countName(teamName);
            long score = getScore(name, nameCnt, teamNameCnt);
            node = compare(node, new Node(teamName, score));
        }
        System.out.println(node.teamName);
    }

    private static Node compare(Node prev, Node next) {
        if (prev == null) return next;

        if (prev.score == next.score) {
            return prev.teamName.compareTo(next.teamName) < 0 ? prev : next;
        }
        return prev.score > next.score ? prev : next;
    }

    private static long getScore(String name, int[] nameCnt, int[] teamNameCnt) {
        long score = 1;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                score *= (nameCnt[a[i]] + teamNameCnt[a[i]]) + (nameCnt[a[j]] + teamNameCnt[a[j]]);
            }
        }

        return score % 100;
    }

    // 이름 세기
    private static int[] countName(String name) {
        int[] teemName = new int[26];
        for (int i = 0; i < name.length(); i++) {
            teemName[name.charAt(i) - 'A']++;
        }
        return teemName;
    }

    private static class Node {
        String teamName;
        long score;

        public Node(String teamName, long score) {
            this.teamName = teamName;
            this.score = score;
        }
    }
}
