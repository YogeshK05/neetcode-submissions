class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n], suff = new int[n], ans = new int[n];
        pre[0] = nums[0];
        suff[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
            suff[n - 1 - i] = suff[n - i] * nums[n - 1 - i];
        }
        for (int i = 0; i < n; i++) {
            int l = i > 0 ? pre[i - 1] : 1;
            int r = i + 1 < n ? suff[i + 1] : 1;
            ans[i] = l * r;
        }
        return ans;
    }
}