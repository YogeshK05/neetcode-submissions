class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>(k, (a, b) -> a.getKey() - b.getKey());
        for (int[]p: points) pq.add(new Pair(p[0]*p[0] + p[1]*p[1], p));
        int[][] ans = new int[k][2];
        while (k-- > 0) ans[k] = pq.remove().getValue();
        return ans;
    }
}