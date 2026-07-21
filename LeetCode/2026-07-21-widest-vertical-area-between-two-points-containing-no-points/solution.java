class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for sorting in Java
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int maxDistance = 0;
        for (int i = 1; i < points.length; i++) {
            maxDistance = Math.max(maxDistance, points[i][0] - points[i - 1][0]);
        }
        return maxDistance;
    }
}