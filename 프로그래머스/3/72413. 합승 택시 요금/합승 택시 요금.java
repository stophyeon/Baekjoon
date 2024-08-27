import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    int N;
    int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        map = new int[n][n];
        N=n;
        
        for(int[] fare : fares){
            map[fare[0]-1][fare[1]-1] = fare[2];
            map[fare[1]-1][fare[0]-1] = fare[2];
        }
        
        int[] together = dijkstra(s - 1);
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if(cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }
    public int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new int[] {0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[1];
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            for (int v = 0; v < N; v++) {
                if(map[u][v] == 0) {
                    continue;
                }
                if (distance[u] + map[u][v] < distance[v]) {
                    distance[v] = distance[u] + map[u][v];
                    pq.add(new int[]{distance[v], v});
                }
            }
        }

        return distance;
    }
}