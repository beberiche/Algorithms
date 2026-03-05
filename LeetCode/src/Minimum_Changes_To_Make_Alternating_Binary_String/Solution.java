package Minimum_Changes_To_Make_Alternating_Binary_String;

public class Solution {
    public int minOperations(String s) {
        // StringBuilder sb = new StringBuilder();
        boolean isStartOne = s.charAt(0) == '1';

        int cnt1 = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = i%2 == 0 ? '1' : '0';
            if(!isStartOne) {
                if(s.charAt(i) == ch) {
                    cnt1++;
                }
            } else {
                if(s.charAt(i) != ch) {
                    cnt1++;
                }
            }
        }

        int cnt2 = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = i%2 == 0 ? '1' : '0';
            if(isStartOne) {
                if(s.charAt(i) == ch) {
                    cnt2++;
                }
            } else {
                if(s.charAt(i) != ch) {
                    cnt2++;
                }
            }
        }

        System.out.printf("cnt1 : %d, cnt2: %d", cnt1, cnt2);
        return Math.min(cnt1, cnt2);
    }
}