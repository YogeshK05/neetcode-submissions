class Solution {
    char[] chars;
    public int countSubstrings(String s) {
        int ans = 0, n = s.length();
        chars = s.toCharArray();
        for (int i = 0; i < n; i++) for (int j = i; j < n; j++) ans += check(i, j) ? 1 : 0;
        return ans;
    }
    private boolean check(int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}