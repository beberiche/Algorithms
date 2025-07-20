package Q10825_국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        String name;
        int korean;
        int english;
        int math;

        Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Node other) {
            if (this.korean != other.korean) {
                return Integer.compare(other.korean, this.korean);
            }
            if (this.english != other.english) {
                return Integer.compare(this.english, other.english);
            }
            if (this.math != other.math) {
                return Integer.compare(other.math, this.math);
            }
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] students = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String name = stk.nextToken();
            int korean = Integer.parseInt(stk.nextToken());
            int english = Integer.parseInt(stk.nextToken());
            int math = Integer.parseInt(stk.nextToken());
            students[i] = new Node(name, korean, english, math);
        }

        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        for (Node student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
