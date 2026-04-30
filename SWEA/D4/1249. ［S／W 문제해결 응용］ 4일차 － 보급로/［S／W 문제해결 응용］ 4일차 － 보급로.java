import java.util.*;
import java.io.*;
class Solution
{
    static int[][] move = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] graph = new int[n][n];
            int[][] dist = new int[n][n];
            for(int[] row : graph){
                Arrays.fill(row, -1);
            }
            for(int[] row : dist){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().split("");
                for(int j = 0; j < n; j++){
                    graph[i][j] = Integer.parseInt(s[j]);
                }
            }
            dist[0][0] = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> (a[2] - b[2]));
            int[] start = {0, 0, 0};
            queue.add(start);

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int cost = current[2];
                if(cost > dist[x][y]) continue;
                for(int i = 0; i < move.length; i++){
                    int nx = x + move[i][0];
                    int ny = y + move[i][1];
                    if(isValid(nx, ny, n) && graph[nx][ny] >= 0){
                        int nextCost = cost + graph[nx][ny];
                        if(nextCost < dist[nx][ny]){
                            dist[nx][ny] = nextCost;
                            queue.add(new int[]{nx, ny, nextCost});
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + dist[n-1][n-1]);
        }
    }

    private static boolean isValid(int x, int y, int n){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}