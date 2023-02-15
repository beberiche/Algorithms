package 세그먼트_트리;

public class Main {

    static class SegmentTree {
        private long[] tree;

        SegmentTree(int size) {
            long h = (long) Math.ceil(Math.log(size) / Math.log(2));
            int tree_size = (int) Math.pow(2, h + 1);
            tree = new long[tree_size];
        }

        long init(long[] arr, int nodeIdx, int start, int end) {
            if (start == end)
                return tree[nodeIdx] = arr[start];

            int mid = (start + end) / 2;
            long left_value = init(arr, nodeIdx * 2, start, mid);
            long right_value = init(arr, nodeIdx * 2 + 1, mid + 1, end);
            return tree[nodeIdx] = left_value + right_value;
        }

        long sum(int nodeIdx, int start, int end, int left, int right) {
            if (end < left || right < start) {
                return 0;
            } else if (left <= start && end <= right) {
                return tree[nodeIdx];
            } else {
                int mid = (start + end) / 2;
                long left_value = sum(nodeIdx * 2, start, mid, left, right);
                long right_value = sum(nodeIdx * 2 + 1, mid + 1, end, left, right);
                return left_value + right_value;
            }
        }

        long update(int nodeIdx, int start, int end, int idx, long new_value) {
            if (idx < start || end < idx) return tree[nodeIdx];
            else if (start == idx && end == idx) {
                return tree[nodeIdx] = new_value;
            } else {
                int mid = (start + end) / 2;
                long left_value = update(nodeIdx * 2, start, mid, idx, new_value);
                long right_value = update(nodeIdx * 2 + 1, mid + 1, end, idx, new_value);
                return tree[nodeIdx] = left_value + right_value;
            }
        }
    }

    static long[] arr;

    public static void main(String[] args) {
        arr = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SegmentTree segmentTree = new SegmentTree(arr.length-1);
        segmentTree.init(arr, 1, 1, arr.length-1);
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 4, 7));
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 9, 10));
        segmentTree.update(1, 1,arr.length-1, 11-1, 11);
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 4, 7));
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 9, 10));
    }
}
