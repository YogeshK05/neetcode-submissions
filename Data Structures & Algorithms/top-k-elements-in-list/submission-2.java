class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int i = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        ArrayList<Integer>[] freq = new ArrayList[n + 1];
        for (int a = 0; a < n + 1; a++) freq[a] = new ArrayList<Integer>();
        for (int b: nums) map.put(b, map.getOrDefault(b, 0) + 1);
        for (Map.Entry<Integer, Integer> e: map.entrySet()) freq[e.getValue()].add(e.getKey());
        while (i < k && n > -1) for (Integer t: freq[n--]) ans[i++] = t;
        return ans;
    }
}