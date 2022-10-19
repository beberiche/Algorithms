package Q6579_트리_복구;

import java.util.Scanner;

public class Main {
    static char[] preOrder, inOrder;
    static int[] inIdx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                preOrder = sc.next().toCharArray();
                inOrder = sc.next().toCharArray();

                inIdx = new int[preOrder.length];
                for (int i = 0; i < inOrder.length; i++) {
                    inIdx[inOrder[i] - 'A'] = i;
                }

                createPostOrder(0, 0, preOrder.length);
                System.out.println();
            }

    }

    private static void createPostOrder(int idx, int left, int right) {
        if (left >= right) return;
        char root = preOrder[idx];
        int rIdx = inIdx[root - 'A'];

        createPostOrder(idx + 1, left, rIdx);
        createPostOrder(idx + 1 + (rIdx - left), rIdx + 1, right);
        System.out.print(root);
    }
}
