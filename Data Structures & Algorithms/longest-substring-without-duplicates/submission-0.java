class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longest = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i))) longest = Math.max(longest, set.size());
            else {
                while (prev <= i) {
                    if (s.charAt(prev) == s.charAt(i)) {
                        prev++;
                        break;
                    }
                    set.remove(s.charAt(prev));
                    prev++;
                }
            }
        }
        return longest;
    }
}
