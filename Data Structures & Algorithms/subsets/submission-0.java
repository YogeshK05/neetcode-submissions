class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        generateSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void generateSubsets(
        int ind, int[] nums, ArrayList<Integer> current, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[ind]);
        generateSubsets(ind + 1, nums, current, ans);
        current.remove(current.size() - 1);
        generateSubsets(ind + 1, nums, current, ans);
        return;
    }
}