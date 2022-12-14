package Q24060_알고리즘_수업_병합_정렬_1;

import java.util.Scanner;

public class Main {
    static int[] sorted;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        sorted = new int[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        if (K > 0) System.out.println(-1);
    }

    private static void mergeSort(int[] arr, int st, int ed) {
        if (st < ed) {
            int mid = (st + ed) / 2;
            mergeSort(arr, st, mid);
            mergeSort(arr, mid + 1, ed);
            merge(arr, st, mid, ed);
        }
    }

    private static void merge(int[] arr, int st, int mid, int ed) {
        int i = st;
        int j = mid + 1;
        int k = st;

        while (i <= mid && j <= ed) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i++];
            } else {
                sorted[k] = arr[j++];
            }
            k++;
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= ed) {
            sorted[k++] = arr[j++];
        }

        for (int t = st; t <= ed; t++) {
            arr[t] = sorted[t];
            if (--K == 0) System.out.println(arr[t]);
        }
    }
}
