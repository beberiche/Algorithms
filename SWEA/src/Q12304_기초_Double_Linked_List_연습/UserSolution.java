package Q12304_기초_Double_Linked_List_연습;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = getNode(-1);
        nodeCnt = 0;
    }

    public void addNode2Head(int data) {
        Node currNode = getNode(data);
        Node headNextNode = head.next;
        head.next = currNode;
        currNode.prev = head;
        if(headNextNode != null) {
            currNode.next = headNextNode;
            headNextNode.prev = currNode;
        }
    }

    public void addNode2Tail(int data) {
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        Node currNode = getNode(data);
        curr.next = currNode;
        currNode.prev = curr;
    }

    public void addNode2Num(int data, int num) {
        Node prev = head;
        for(int i=1; i<num; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        Node curr = getNode(data);
        prev.next = curr;
        curr.prev = prev;
        if(next != null) {
            curr.next = next;
            next.prev = curr;
        }
    }

    public int findNode(int data) {
        Node curr = head.next;
        int idx = 1;
        while(curr !=null) {
            if(curr.data == data) {
                break;
            }
            curr = curr.next;
            idx++;
        }
        return idx;
    }

    public void removeNode(int data) {
        Node curr = head.next;
        while(curr != null) {
            if(curr.data == data) {
                curr.prev.next = curr.next;
                if(curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                break;
            }
            curr = curr.next;
        }

    }

    public int getList(int[] output) {
        Node curr = head.next;
        int idx = 0;
        while(curr != null) {
            output[idx] = curr.data;
            curr= curr.next;
            idx++;
        }
        return idx;
    }

    public int getReversedList(int[] output) {
        Node curr = head.next;
        while(curr.next != null) {
            curr = curr.next;
        }
        int idx = 0;
        while(curr != head) {
            output[idx] = curr.data;
            curr = curr.prev;
            idx++;
        }
        return idx;
    }
}