package 단속카메라;

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (n1, n2)-> n1[1]-n2[1]);
        int curr =routes[0][1];
        for(int i=1; i< routes.length; i++) {
            if(curr < routes[i][0]) {
                answer++;
                curr = routes[i][1];
            }

        }
        return answer;
    }
}