class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], curr = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (curr < 0) curr = 0;
            curr += nums[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
