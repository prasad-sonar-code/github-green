class Solution {
    // Time complexity: O(n + m), where n is the number of vertices and m is the number of edges
    // Space complexity: O(n + m)
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int minCycleLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int[] distance = new int[n];
            Arrays.fill(distance, -1);
            distance[i] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph[u]) {
                    if (distance[v] == -1) {
                        distance[v] = distance[u] + 1;
                        queue.offer(v);
                    } else if (distance[u] + 1 < distance[v]) {
                        minCycleLength = Math.min(minCycleLength, distance[u] + 1 + distance[v]);
                    }
                }
            }
        }
        
        return minCycleLength == Integer.MAX_VALUE ? -1 : minCycleLength;
    }
}