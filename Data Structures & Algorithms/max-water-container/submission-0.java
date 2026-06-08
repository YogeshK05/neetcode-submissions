class Solution {
    public int maxArea(int[] heights) {
        int area = 0, l = 0, r = heights.length - 1;
        while (l < r) {
            area = Math.max(area, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[r] > heights[l]) l++;
            else r--;
        }
        return area;
    }
}
