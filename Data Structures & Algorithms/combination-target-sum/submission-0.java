class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        itr(ans, set, new ArrayList<>(), candidates, target, 0, 0);
        return ans;
    }

    private void itr(List<List<Integer>> ans, HashSet<ArrayList<Integer>> set,
        ArrayList<Integer> curr, int[] candidates, int target, int ind, int sum) {
        if (sum == target || ind == candidates.length) {
            if (sum == target && set.add(curr))
                ans.add(curr);
            return;
        }
        if (sum + candidates[ind] <= target) {
            ArrayList<Integer> c1 = new ArrayList<>(curr);
            c1.add(candidates[ind]);
            itr(ans, set, c1, candidates, target, ind, sum + candidates[ind]);
        }
        if (sum < target)
            itr(ans, set, curr, candidates, target, ind + 1, sum);
    }
}