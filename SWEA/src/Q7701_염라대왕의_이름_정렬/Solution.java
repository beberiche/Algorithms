package Q7701_염라대왕의_이름_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static String[] arr;
    static String[] buff;
    static int N;
    static Scanner sc = new Scanner(System.in);
    static int l,r,idx;
    private static void input() {
        N = sc.nextInt();
        arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.next();
        }
    }

    private static void mergeSort(int st, int ed) {
        if(st >= ed) return;
        int mid = (st+ed)/2;
        mergeSort(st, mid);
        mergeSort(mid+1, ed);
        merge(st,mid,ed);
    }

    private static void merge(int st, int mid, int ed) {
        buff = new String[arr.length];
        l = st;
        r = mid+1;
        idx = st;
        while(l<=mid && r<=ed) {
            shuffle();
        }

        while(l<=mid) {
            buff[idx++] = arr[l++];
        }

        while(r<=ed) {
            buff[idx++] = arr[r++];
        }

        for(int i=st; i<=ed; i++) {
            arr[i] = buff[i];
        }
    }

    private static void shuffle() {
        if(arr[l].length() == arr[r].length()) {
            for(int i=0; i<arr[l].length(); i++) {
                char s1 = arr[l].charAt(i);
                char s2 = arr[r].charAt(i);
                if(s1 == s2) continue;
                else if(s1 < s2) {
                    buff[idx++] = arr[l++];
                    return;
                } else {
                    buff[idx++] = arr[r++];
                    return;
                }
            }
        }
        else if(arr[l].length() < arr[r].length()) {
            buff[idx++] = arr[l++];
            return;
        } else {
            buff[idx++] = arr[r++];
            return;
        }
        r++;
        idx++;
    }

    private static void output(int t, int n) {
        System.out.println("#"+t);
        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            input();
            mergeSort(0, N-1);
            output(t, N);
        }
    }
}
