package Remove_Element;

class Solution {
    public int removeElement(int[] nums, int val) {
        int st = 0;
        int ed = nums.length - 1;
        if(ed < 0) {
            return 0;
        }

        int cnt = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]==val) {
                cnt++;
            }
        }
        while(st < ed) {
            if(nums[st] != val) {
                st++;
                continue;
            }

            if(nums[ed] == val) {
                ed--;
                continue;
            }

            int tmp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = tmp;
            st++;
        }

        return nums.length - cnt;
    }
}