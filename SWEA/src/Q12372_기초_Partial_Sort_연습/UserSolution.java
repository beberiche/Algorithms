package Q12372_기초_Partial_Sort_연습;

public class UserSolution {
    static final int MAX = 100000;
    private int[][] heap;
    private int last=0;

    public void init() {
        heap = new int[MAX+1][2];
        last = 0;
    }

    public void addUser(int uID, int income) {
        heap[++last][0] = uID;
        heap[last][1] = income;


        int idx = last;
        while (idx/2 > 0) {
            if (compare(idx/2, idx) == 1) {
                swap(idx/2, idx);
            } else break;

            idx/= 2;
        }
    }

    private void swap(int i, int j) {
        int a = heap[i][0];
        int b = heap[i][1];
        heap[i][0] = heap[j][0];
        heap[i][1] = heap[j][1];
        heap[j][0] = a;
        heap[j][1] = b;
    }

    private int compare(int i, int j) {
        if (j == -1) {
            return 0;
        } else {
            return heap[i][1] > heap[j][1] || (heap[i][1] == heap[j][1] && heap[i][0] < heap[j][0]) ? 0 : 1;
        }
    }

    public int getTop10(int[] result) {
        int[][] tmp = new int[10][2];

        int idx;
        for (idx = 0; idx < 10 && 0 < last; idx++) {
            tmp[idx][0] = heap[1][0];
            tmp[idx][1] = heap[1][1];

            heap[1][0] = heap[last][0];
            heap[1][1] = heap[last][1];
            last -= 1;

            int parent = 1;
            while (parent*2 <= last) {

                int left = parent * 2;
                int right = parent * 2 + 1;

                right = right <= last ? right : -1;

                int min = compare(left, right) == 0 ? left : right;

                if (compare(parent, min) == 0)
                    break;

                swap(parent, min);
                parent = min;
            }
        }

        for (int i = 0; i < idx; i++) {
            result[i] = tmp[i][0];
            addUser(tmp[i][0], tmp[i][1]);
        }

        return idx;
    }
}