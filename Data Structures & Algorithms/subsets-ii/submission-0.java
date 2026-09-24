class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        generateSubsets(0, nums, new ArrayList<>(), set, ans);
        return ans;
    }
    private void generateSubsets(
        int ind, int[] nums, ArrayList<Integer> current, HashSet set, List<List<Integer>> ans) {
        if (ind == nums.length) {
            if (set.add(current))
                ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[ind]);
        generateSubsets(ind + 1, nums, current, set, ans);
        current.remove(current.size() - 1);
        generateSubsets(ind + 1, nums, current, set, ans);
        return;
    }
}
