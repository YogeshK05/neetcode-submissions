class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(ans, n, k, 1, new ArrayList<>());
        return ans;
    }
    private void bt(List<List<Integer>> ans, int n, int k, int i, List<Integer> curr) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(i);
        if (i <= n)
            bt(ans, n, k, i + 1, curr);
        curr.remove(curr.size() - 1);
        if (i <= n)
            bt(ans, n, k, i + 1, curr);
    }
}