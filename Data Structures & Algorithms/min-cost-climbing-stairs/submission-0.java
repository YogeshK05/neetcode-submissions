class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = cost[cost.length - 1], two = 0;
        for (int i = cost.length - 2; i > -1; i--) {
            int temp = one;
            one = cost[i] + Math.min(one, two);
            two = temp;
        }
        return Math.min(one, two);
    }
}
