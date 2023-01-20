package Q13051_수열_편집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static final int NODE_MAX = 4000;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    static class LinkedList {
        Node head;
        Node tail;
        Node[] nodeArr;
        int nodeCnt;
        int linkedCnt;

        public LinkedList() {
            head = null;
            tail = null;
            nodeArr = new Node[NODE_MAX];
            nodeCnt = 0;
        }

        private Node createNode(int data) {
            Node newNode = new Node(data);
            nodeArr[nodeCnt++] = newNode;
            return newNode;
        }

        private void insert(int idx, int data) {
            Node newNode = new Node(data);
            if (idx == 0) {
                newNode.next = head;
                head = newNode;
            } else if (idx == linkedCnt - 1) {
                tail.next = newNode;
                tail = newNode;
            } else {
                Node currNode = head;
                for (int i = 1; i < idx; i++) currNode = currNode.next;
                newNode.next = currNode.next;
                currNode.next = newNode;
            }
            linkedCnt++;
        }

        private void delete(int idx) {
            Node currNode = head;
            if (idx == 0) head = currNode.next;
            else {
                for (int i = 1; i < idx; i++) currNode = currNode.next;
                currNode.next = currNode.next == null ? null : currNode.next.next;
            }
            linkedCnt--;
        }

        private void change(int idx, int data) {
            Node currNode = head;
            for (int i = 1; i <= idx; i++) currNode = currNode.next;
            currNode.data = data;
        }

        private void init(int data) {
            Node newNode = createNode(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                Node currNode = tail;
                tail.next = newNode;
                tail = newNode;
            }
            linkedCnt++;
        }

        private int explore(int idx) {
            if(linkedCnt <= idx) {
                return -1;
            } else {
                Node currNode = head;
                for(int i=1; i<=idx; i++) currNode = currNode.next;
                return currNode.data;
            }
        }
    }

    static int N, M, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t+" ");
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            L = Integer.parseInt(stk.nextToken());
            LinkedList list = new LinkedList();

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.init(Integer.parseInt(stk.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                stk = new StringTokenizer(br.readLine());
                char cmd = stk.nextToken().charAt(0);

                switch (cmd) {
                    case 'I':
                        list.insert(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
                        break;
                    case 'D':
                        list.delete(Integer.parseInt(stk.nextToken()));
                        break;
                    case 'C':
                        list.change(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
                        break;
                }
            }
            sb.append(list.explore(L)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
