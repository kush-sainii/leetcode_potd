import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[nums2.length];
        for(int i = nums2.length - 1; i>=0; i--) {
            while (!stk.isEmpty() && stk.peek() < nums2[i] ) {
                stk.pop();
            }
            if(stk.isEmpty()){
                res[i] = -1;
                stk.push(nums2[i]);
                continue;
            }
            if(stk.peek() > nums2[i]) {
                res[i] = stk.peek();
                stk.push(nums2[i]);
                continue;
            }
            stk.push(nums2[i]);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums2.length; i++) {
            hm.put(nums2[i], res[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i<ans.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}