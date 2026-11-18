class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        int[] suffixSum = new int[candidates.length];
        suffixSum[candidates.length - 1] = candidates[candidates.length - 1];
        for (int i = candidates.length - 2; i > -1; i--)
            suffixSum[i] = candidates[i] + suffixSum[i + 1];
        findSum(ans, candidates, suffixSum, target, 0, 0, new ArrayList<>());
        return ans;
    }
    private void findSum(List<List<Integer>> ans, int[] candidates, int[] suffixSum, int t, int s,
        int i, List<Integer> curr) {
        if (i >= candidates.length || s >= t) {
            if (s == t)
                ans.add(new ArrayList<>(curr));
            return;
        }
        if (s + suffixSum[i] < t)
            return;
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1])
                continue;
            curr.add(candidates[j]);
            findSum(ans, candidates, suffixSum, t, s + candidates[j], j + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}