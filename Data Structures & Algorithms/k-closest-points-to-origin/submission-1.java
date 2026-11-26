class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            double d1 = Math.sqrt(a[1] * a[1] + a[0] * a[0]);
            double d2 = Math.sqrt(b[1] * b[1] + b[0] * b[0]);
            return d1 < d2 ? -1 : 1;
        });
        for (int[] p : points) q.add(p);
        int[][] ans = new int[k][2];
        while (k-- > 0 && q.size() > 0) ans[k] = q.remove();
        return ans;
    }
}
