package Remove_Duplicates_From_Sorted_Array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int[] a = new int[204];

        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            if(++a[nums[i]+100] > 1) {
                cnt++;
            }
        }

        int idx = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i] > 0) {
                nums[idx++] = i-100;
            }
        }

        for(int i=idx; i<cnt; i++) {
            nums[idx] = 100;
        }
        return nums.length - cnt;
    }
}