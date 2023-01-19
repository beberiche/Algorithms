package Q1230_암호문3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int NODE_MAX = 100000;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        Node[] nodeArr;
        int nodeCnt;

        public LinkedList() {
            head = null;
            nodeArr = new Node[NODE_MAX];
            nodeCnt = 0;
        }

        Node addNode(int data) {
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        void insert(int idx, int[] numArr) {
            if(idx == 0) {
                Node newNode = addNode(numArr[0]);
                newNode.next = head;
                head = newNode;
                Node currNode = head;
                for(int i=1; i<numArr.length; i++) {
                    newNode = addNode(numArr[i]);
//                    newNode.next = head.next;
                    newNode.next = currNode.next;
                    currNode.next = newNode;
                    currNode = newNode;
                }
                return;
            }
            Node currNode = head;
            for(int i=1; i<idx; i++) {
                currNode = currNode.next;
            }
            for(int i=0; i<numArr.length; i++) {
                Node newNode = addNode(numArr[i]);
                newNode.next = currNode.next;
                currNode.next = newNode;
                currNode = newNode;
            }
        }

        void delete(int idx, int cnt) {
            Node currNode = head;
            if(idx == 0) {
                for(int i=0; i<cnt; i++) {
                    currNode = currNode.next;
                }
                head = currNode;
                return;
            }
            for(int i=1; i<idx; i++) {
                currNode = currNode.next;
            }
            Node fixNode = currNode;
            for(int i=0; i<cnt; i++) {
                currNode = currNode.next;
            }
            fixNode.next = currNode.next;
        }

        void add(int data) {
            Node currNode = tail;
            Node newNode = addNode(data);
            currNode.next = newNode;
            tail = newNode;
        }

        void init(int data) {
            Node newNode = addNode(data);
            if (nodeCnt <= 1) {
                head = newNode;
                tail = newNode;
            } else {
                nodeArr[nodeCnt - 2].next = newNode;
                tail = newNode;
            }
        }

        void print(StringBuilder sb) {
            int cnt = 10;
            Node currNode = head;
            while(--cnt >=0) {
                sb.append(currNode.data).append(" ");
                currNode = currNode.next;
                if(currNode == null) break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        StringTokenizer stk;
        for (int t = 1; t <= T; t++) {
            LinkedList list = new LinkedList();
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(stk.nextToken());
                list.init(num);
            }
            int M = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char cmd = stk.nextToken().charAt(0);
                int x, y;
                switch (cmd) {
                    case 'I':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        int[] temp = new int[y];
                        for (int j = 0; j < y; j++) {
                            temp[j] = Integer.parseInt(stk.nextToken());
                        }
                        list.insert(x, temp);
                        break;
                    case 'D':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        list.delete(x, y);
                        break;
                    case 'A':
                        y = Integer.parseInt(stk.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.add(Integer.parseInt(stk.nextToken()));
                        }
                        break;
                }
            }
            list.print(sb);
            System.out.println(sb.toString());
        }
    }
}
