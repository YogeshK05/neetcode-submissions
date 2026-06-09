class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, c = 0, i = digits.length - 1;
        while (i > -1) {
            if (i == n - 1) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    c = 1;
                } else digits[i] += 1;
            } else if (c == 1) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    c = 0;
                }
            }
            i--;
        }
        int[] ans = digits;
        if (c == 1) {
            ans = new int[n + 1];
            ans[0] = 1 + digits[0];
            for (int k = 0; k < n; k++) {
                ans[k + 1] = digits[k];
            }
        }
        return ans;
    }
}