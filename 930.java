class Solution {
    public static int helper(int[] nums1, int goal) {
        if(goal<0) return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;
        while(r<nums1.length){
            sum+=nums1[r];
            while(sum>goal) {
                sum = sum - nums1[l];
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return (helper(nums, goal) - helper(nums, goal-1));
    }
}