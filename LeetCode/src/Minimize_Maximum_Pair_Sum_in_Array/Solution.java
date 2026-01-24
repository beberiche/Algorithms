package Minimize_Maximum_Pair_Sum_in_Array;

import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for(int i=0, j=nums.length-1; i<j; i++, j--) {
            n = Math.max(nums[i]+nums[j], n);
        }
        return n;
    }
}