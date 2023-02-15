package 세그먼트_트리;

public class Main {


    // 세그먼트 트리
    // 중요점 3가지 : 트리 배열 초기화, 구간의 합, 배열 업데이트
    static class SegmentTree {
        private long[] tree;

        SegmentTree(int size) {
            // arr 배열에 이진 트리화 하는 경우 필요한 노드의 배열 갯수는, 2^(N+1)이다.
            // arr.length = 11 인 경우, 해당 갯수를 모두 받기 위해 필요한 노드 배열의 개수는 2^4 인 16개이다.
            // 구간합을 구하기 위해 각 리프 노드에 필요한 부모 노드 배열의 개수는 2^4-1 인 15개 이다. (루트 노드는 1개)
            // 따라서 총 32개의 배열로 시작하되, 1부터 시작하면 딱 맞는다.
            long h = (long) Math.ceil(Math.log(size) / Math.log(2));
            int tree_size = (int) Math.pow(2, h + 1);
            tree = new long[tree_size];
        }


        // arr 배열을 토대로 tree[](이진트리) 로 초기화하기
        long init(long[] arr, int nodeIdx, int start, int end) {
            // 세그먼트 트리의 리프 노드에 도달한 경우
            if (start == end)
                // 리프노드에 배열의 값을 저장 후 리턴
                return tree[nodeIdx] = arr[start];

            // 중간값
            int mid = (start + end) / 2;
            // 리프 노드가 아닌 경우라면 인접 자식 노드의 값들을 찾고,
            long left_value = init(arr, nodeIdx * 2, start, mid);
            long right_value = init(arr, nodeIdx * 2 + 1, mid + 1, end);
            // 이를 두 자식 노드를 더한 값이 부모 노드의 값이다.
            return tree[nodeIdx] = left_value + right_value;
        }

        long sum(int nodeIdx, int start, int end, int left, int right) {
            // 현재 이동한 노드가 구간에 속하지 않는 경우
            if (end < left || right < start) {
                return 0;
            } else if (left <= start && end <= right) {
                // 현재 이동한 노드가 구간에 속한다면 해당 노드 반환
                return tree[nodeIdx];
            } else {
                // 여기서는 총 2가지 경우가 존재,
                // 1. 현재 노드의 두 자식 노드가 합의 구간에 일부는 속하고 일부는 속하지 않는 경우
                // 2. 현재 노드의 두 자식 노드가 합의 구간에 모두 속하는 경우
                int mid = (start + end) / 2;
                long left_value = sum(nodeIdx * 2, start, mid, left, right);
                long right_value = sum(nodeIdx * 2 + 1, mid + 1, end, left, right);
                return left_value + right_value;
            }
        }

        long update(int nodeIdx, int start, int end, int idx, long new_value) {
            // 현재 구간이 idx와 관련이 없는 경우
            if (idx < start || end < idx) return tree[nodeIdx];
            else if (start == idx && end == idx) {
                // 현재 노드가 변경해야할 노드인 경우, 값 변경
                return tree[nodeIdx] = new_value;
            } else {
                // 현재 노드가 가지는 값의 구간이 변경해야할 인덱스가 포함되는 경우,
                // 업데이트 된 값을 기반으로 해당 부모노드 변경
                // 최종 루트 노드는 업데이트 된 tree[] 의 총합이 된다.
                int mid = (start + end) / 2;
                long left_value = update(nodeIdx * 2, start, mid, idx, new_value);
                long right_value = update(nodeIdx * 2 + 1, mid + 1, end, idx, new_value);
                return tree[nodeIdx] = left_value + right_value;
            }
        }
    }

    static long[] arr;

    public static void main(String[] args) {
        // 배열 변수 선언 (배열의 인덱스는 1에서 시작)
        arr = new long[]{0, 5, 1, 7, 9, 5, 14, 22, 1, 5, 2};
        // 세그먼트 트리 생성
        SegmentTree segmentTree = new SegmentTree(arr.length-1);
        segmentTree.init(arr, 1, 1, arr.length-1);
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 4, 7));
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 9, 10));
        segmentTree.update(1, 1,arr.length-1, 11-1, 11);
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 4, 7));
        System.out.println(segmentTree.sum(1, 1, arr.length-1, 9, 10));
    }
}
