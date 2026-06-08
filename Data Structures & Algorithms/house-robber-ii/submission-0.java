class Solution {
    int N;
    int[] dp;
    boolean[] visited;
    public int rob(int[] nums) {
        N = nums.length;
        if (N == 1) return nums[0];
        dp = new int[N];
        visited = new boolean[N];
        int ans1 = dfs(nums, 0, N - 1);
        dp = new int[N];
        visited = new boolean[N];
        int ans2 = dfs(nums, 1, N);
        return Math.max(ans1, ans2);
    }
    private int dfs(int[] nums, int curr, int end) {
        if (curr >= end) return 0;
        if (visited[curr]) return dp[curr];
        int take = dfs(nums, curr + 2, end) + nums[curr];
        int notTake = dfs(nums, curr + 1, end);
        visited[curr] = true;
        dp[curr] = Math.max(take, notTake);
        return dp[curr];
    }
}