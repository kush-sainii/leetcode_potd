class Solution {
    public boolean cantAdd(HashMap<Integer, Integer> hm, int k){
        boolean sz = hm.size() > k ? true : false;
        return sz;
    }
    private int atMostK(int[] nums, int k) {
        int start = 0, end = 0;
        int n = nums.length;
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(end < n) {
            int curr = nums[end];
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
            while(cantAdd(hm,k)) {       
                int leftNum = nums[start];
                hm.put(leftNum, hm.get(leftNum) - 1);
                if(hm.get(nums[start]) == 0){
                    hm.remove(nums[start]);
                }
                start++;
            }
            cnt += (end - start + 1);  
            end++;
        }    
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
}