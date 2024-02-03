package merge_sort;

public class Main {
    static int[] arr = {1, 4, 2, 31, 2, 5, 2, 7, 9};
    static int[] buff;

    public static void main(String[] args) {
        mergeSort(0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int st, int ed) {
        if (st >= ed) {
            System.out.println(st);
            return;
        }
        int mid = (st + ed) / 2;
        mergeSort(st, mid);
        mergeSort(mid + 1, ed);
        merge(st, mid, ed);
    }

    private static void merge(int st, int mid, int ed) {
        buff = new int[arr.length];
        int l = st;
        int r = mid + 1;
        int idx = st;
        while (l <= mid && r <= ed) buff[idx++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        while (l <= mid) buff[idx++] = arr[l++];
        while (r <= ed) buff[idx++] = arr[r++];

        for (int i = st; i <= ed; i++) {
            arr[i] = buff[i];
        }
    }
}
