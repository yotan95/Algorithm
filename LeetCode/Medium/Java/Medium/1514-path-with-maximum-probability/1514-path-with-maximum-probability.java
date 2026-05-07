import java.util.*;
class Solution {
    public class Edge implements Comparable<Edge>{
        int to;
        double cost;
        Edge(int to, double cost){
            this.to = to;
            this.cost= cost;
        }

        @Override
        public int compareTo(Edge e){
            return Double.compare(e.cost, this.cost);
        }
    }
    public double maxProbability(
        int n, int[][] edges, double[] succProb,int start_node, int end_node) {
        
        Map<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
        double[] dist = new double[n+1];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;

        for(int i = 0; i <=n ; i++){
            graph.putIfAbsent(i, new ArrayList<Edge>());
        }

        for(int i = 0 ; i < edges.length;i++){
            int to = edges[i][0], from = edges[i][1];
            double cost = succProb[i];
            graph.get(to).add(new Edge(from, cost));
            graph.get(from).add(new Edge(to, cost));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.offer(new Edge(start_node, 1.0));

        while(!queue.isEmpty()){
            Edge cur = queue.poll();
            ArrayList<Edge> list = graph.get(cur.to);

            for(int i = 0 ; i < list.size(); i++){
                Edge next = list.get(i);
                
                if(cur.cost < dist[cur.to]) continue;
                double newCost = cur.cost * next.cost;
                if(dist[next.to] < newCost ){
                    dist[next.to] = newCost;
                    queue.offer(new Edge(next.to, newCost));
                }
                
            }
        }
        if(dist[end_node] == Double.MAX_VALUE) return 0;

        return dist[end_node];
    }
}