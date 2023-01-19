package Q12303_기초_Singled_Linked_List_연습;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
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
        node = new Node[MAX_NODE];
        nodeCnt = 0;
        head = null;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (true) {
            if (currNode.next == null) break;
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void addNode2Num(int data, int num) {
        if (num == 1) {
            addNode2Head(data);
        } else if (num == nodeCnt + 1) {
            addNode2Tail(data);
        } else {
            Node newNode = getNode(data);
            Node preNode = null;
            Node nextNode = head;
            while (--num >= 1) {
                preNode = nextNode;
                nextNode = nextNode.next;
            }
            newNode.next = nextNode;
            preNode.next = newNode;
        }
    }

    public void removeNode(int data) {
        Node preNode = null;
        Node nextNode = head;
        int tmp = nodeCnt;
        while (--tmp >= 0) {
            if (nextNode.data == data) {
                break;
            }
            preNode = nextNode;
            nextNode = nextNode.next;
        }
        if(tmp < 0) {
            return;
        }

        if(nextNode.next == null) {
            preNode.next = null;
        } else if(preNode == null) {
            head = nextNode.next;
            nextNode.next = null;
        } else {
            preNode.next = nextNode.next;
        }

    }

    public int getList(int[] output) {
        Node currNode = head;
        int idx = 0;
        while (currNode != null) {
            output[idx++] = currNode.data;
            currNode = currNode.next;
        }
        return idx;
    }
}