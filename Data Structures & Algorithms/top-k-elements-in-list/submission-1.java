class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (Map.Entry<Integer, Integer> e: map.entrySet()) q.add(new Pair(e.getValue(), e.getKey()));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.remove().getValue();
        return ans;
    }
}
