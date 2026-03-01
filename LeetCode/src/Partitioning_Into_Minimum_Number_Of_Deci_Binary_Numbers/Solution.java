package Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;

class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); ++i)
            res = Math.max(res, n.charAt(i) - '0');
        return res;
    }
}