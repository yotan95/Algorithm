import java.util.*;

class Solution {

    public class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]= 0;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<Edge>());
        }        
        for(int i = 0 ; i < times.length; i++){
            int from = times[i][0], to = times[i][1], cost = times[i][2];
            graph.get(from).add(new Edge(from, to, cost));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(k,k,0));

        while(!queue.isEmpty()){
            Edge cur = queue.poll();
            List<Edge> adjacent = graph.get(cur.from);
            for(int i = 0 ; i < adjacent.size(); i++){
                Edge next = adjacent.get(i);
                
                if(cur.cost > dist[cur.from]) continue;
                int newCost = cur.cost + next.cost;

                if(newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    queue.add(new Edge(next.to, next.to, newCost));
                }

            }
        }

        int answer = Arrays.stream(dist,1,n+1).max().getAsInt();

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;

    }
}