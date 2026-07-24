class Solution {
    // Time complexity: O(n * m) where n is the number of points and m is the number of queries
    // Space complexity: O(m) where m is the number of queries
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int[] point : points) {
                // Calculate the Euclidean distance between the point and the circle's center
                int distance = (int) Math.sqrt(Math.pow(point[0] - queries[i][0], 2) + Math.pow(point[1] - queries[i][1], 2));
                // If the distance is less than or equal to the radius, increment the count
                if (distance <= queries[i][2]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}