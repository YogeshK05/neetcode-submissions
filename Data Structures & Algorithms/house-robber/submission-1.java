class Solution {
    int N;
    int[] dp;
    boolean[] visited;
    public int rob(int[] nums) {
        N = nums.length;
        dp = new int[N];
        visited = new boolean[N];
        return dfs(nums, 0);
    }
    private int dfs(int[] nums, int curr) {
        if (curr >= N) return 0;
        if (visited[curr]) return dp[curr];
        int take = dfs(nums, curr + 2) + nums[curr];
        int notTake = dfs(nums, curr + 1);
        visited[curr] = true;
        dp[curr] = Math.max(take, notTake);
        return dp[curr];
    }
}