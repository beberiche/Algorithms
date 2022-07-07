package N개의최소공배수;

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int num = arr[arr.length-1];
        int idx = 1;
        int answer = 0;
        while(true) {
            answer=num*idx;
            boolean check = true;
            for(int i=0; i<arr.length; i++) {
                if(answer%arr[i] !=0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                return answer;
            }
            idx++;
        }
        
    }
}