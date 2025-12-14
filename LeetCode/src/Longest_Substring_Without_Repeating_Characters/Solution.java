package Longest_Substring_Without_Repeating_Characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = new Solution().lengthOfLongestSubstring(br.readLine());
        System.out.println(answer);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> ss = new HashSet<>();

        int l= 0;
        int r= 0;

        int idx = 0;
        while(r < s.length()) {
            char part = s.charAt(r);
            // 존재하는 경우
            if(ss.contains(part)) {
                ss.remove(s.charAt(l++));
            } else {
                ss.add(part);
                r++;
                max = Math.max(max, ss.size());
            }
        }

        return max;
    }
}