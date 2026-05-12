import java.util.*;

class Solution {

    static int[][] move = {{0,1}, {1,0},{-1,0},{0,-1}};

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] dist = new int[row][col];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        for(int i = 0 ; i < dist.length; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        queue.offer(new int[] {0,0,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x= cur[0];
            int y = cur[1];
            int effort = cur[2];
            for(int i = 0 ; i < move.length; i++){
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if(isValid(nx, ny, row, col)){
                    int nEffort = Math.abs(heights[x][y] - heights[nx][ny]);
                    int newEffort = Math.max(effort, nEffort);
                    if(newEffort < dist[nx][ny]){
                        dist[nx][ny] = newEffort;
                        queue.offer(new int[]{nx,ny, newEffort});
                    }
                }
                
            }
        }
        return dist[row-1][col-1];

    }

    private static boolean isValid(int x, int y, int row, int col){
        return x>=0 && x < row && y >=0 && y < col;
    }
}