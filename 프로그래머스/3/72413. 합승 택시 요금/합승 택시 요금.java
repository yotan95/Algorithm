import java.util.*;


class Solution {
    static Map<Integer, ArrayList<int[]>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        graph = new HashMap<Integer, ArrayList<int[]>>();
        
        for(int i = 1; i <= n ; i++){
            graph.putIfAbsent(i, new ArrayList<int[]>());
        }
        for(int i = 0 ; i < fares.length; i++){
            int r1 = fares[i] [0], r2 = fares[i][1], cost = fares[i][2];
            graph.get(r1).add(new int[]{r2, cost});
            graph.get(r2).add(new int[]{r1, cost});
        }
            
            
        int[] costA = dijk(n,a);
        int[] costB = dijk(n,b);
        int[] costS = dijk(n,s);
        int answer = Integer.MAX_VALUE;
        for(int i =1 ; i <=n; i++){
            answer = Math.min(answer, costA[i]+costB[i]+costS[i]);
        }
        
        return answer;
    }
    
    
    public static int[] dijk(int n, int point){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[point] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]);
        queue.offer(new int[] {point, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int fare = cur[0];
            int cost = cur[1];
            
            if(cost > dist[fare]) continue;
            
            List<int[]> list = graph.get(fare);
            for(int j = 0 ; j < list.size(); j++){
                int[] next = list.get(j);
                int nextFare = next[0];
                int nextCost = cost + next[1];
                if(nextCost < dist[nextFare]){
                    dist[nextFare] = nextCost;
                    queue.offer(new int[]{nextFare, nextCost});
                }
            }
        }
        return dist;
    }
}