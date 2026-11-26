class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) q.add(n);
        while (k-- > 1) q.remove();
        return q.remove();
    }
}