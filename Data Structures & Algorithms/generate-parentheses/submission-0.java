class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, n, 0, 0, "");
        return ans;
    }
    private void generate(List<String> ans, int n, int o, int c, String curr) {
        if (o == c && o == n) {
            ans.add(curr);
            return;
        }
        if (o < n) {
            curr += '(';
            generate(ans, n, o + 1, c, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (c < o) {
            curr += ')';
            generate(ans, n, o, c + 1, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
