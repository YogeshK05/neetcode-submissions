class Solution {
    char[] chars;
    int n;
    public String longestPalindrome(String s) {
        int[] cords = new int[] { 0, 0 };
        n = s.length();
        chars = s.toCharArray();
        for (int i = 0; i < n; i++) for (int j = i; j < n; j++) if (check(i, j) && (j - i) >= (cords[1] - cords[0])) cords = new int[] { i, j };
        String ans = "";
        for (int i = cords[0]; i <= cords[1]; i++) ans += chars[i];
        return ans;
    }
    private boolean check(int i, int j) {
        while (i < j && i < n && j > -1) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}