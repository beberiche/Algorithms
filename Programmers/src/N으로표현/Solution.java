package N으로표현;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Queue<int[]> q = new LinkedList<>(); 
        // arr[0] = N
        // arr[1] = depth;
        q.add(new int[] {N, 1});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==number) {
                answer = curr[1];
                break;
            } 
            if(curr[1] > 8) 
                break;
            
            int temp = N;
            for(int i=1; i<=8; i++) {
                if(curr[1] > 8)
                    break;
                
                q.add(new int[] {curr[0]+temp, curr[1]+i});
                q.add(new int[] {curr[0]*temp, curr[1]+i});
          
                if(curr[0]-N > 0)
                    q.add(new int[] {curr[0]-temp, curr[1]+i});
                else 
                    q.add(new int[] {temp-curr[0], curr[1]+i});
           
                if(curr[0] != 0) 
                    q.add(new int[] {curr[0]/temp, curr[1]+i}); 
                if(temp != 0) 
                    q.add(new int[] {temp/curr[0], curr[1]+i});
                
                temp = temp * 10 + N;   
            }
            
        }
        
        
        return answer;
    
    }
}