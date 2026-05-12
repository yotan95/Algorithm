import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 1; i <= n ; i++){
            graph.putIfAbsent(i, new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < roads.length ; i++){
            int r1 = roads[i][0];
            int r2 = roads[i][1];
            
            graph.get(r1).add(r2);
            graph.get(r2).add(r1);
        }
        List<Integer> an = new ArrayList<Integer>();
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        queue.offer(new int[]{destination, 0});
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[destination] = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int start = cur[0];
            int cost = cur[1];
            
            List<Integer> list = graph.get(start);
            
            if(cost > dist[start]) continue;
            
            for(int i = 0 ; i < list.size(); i++){
                int next = list.get(i);
                int newCost = cost + 1;
                if(newCost < dist[next]){
                    dist[next] = newCost;
                    queue.offer(new int[]{next, newCost});
                }
            }
            
        }
        
        for(int i = 0 ; i < sources.length; i++){
            if(dist[sources[i]] == Integer.MAX_VALUE) an.add(-1);
            else an.add(dist[sources[i]]);
        }
        return an.stream().mapToInt(Integer::intValue).toArray();
        

    }
}