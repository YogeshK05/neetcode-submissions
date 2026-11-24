class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        List<String> ans = new ArrayList<>();
        if (digits.length() > 0)
            generate(map, ans, digits, 0, "");
        return ans;
    }
    private void generate(
        HashMap<Character, char[]> map, List<String> ans, String digits, int i, String curr) {
        if (i == digits.length()) {
            ans.add(curr);
            return;
        }
        char digit = digits.charAt(i);
        for (int d = 0; d < map.get(digit).length; d++) {
            curr += map.get(digit)[d];
            generate(map, ans, digits, i + 1, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
