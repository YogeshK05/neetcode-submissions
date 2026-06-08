class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero = -1, total = 1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && zero > -1) return new int[n];
            if (nums[i] == 0) zero = i;
            else total *= nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (zero > -1) nums[i] = i != zero ? 0 : total;
            else nums[i] = total / nums[i];
        }
        return nums;
    }
}