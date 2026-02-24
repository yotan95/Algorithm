import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int rSize = maps.length;
        int cSize = maps[0].length;
        int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean[][] visited = new boolean[rSize][cSize];
        
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start  = {0,0};
        queue.add(start);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[1];
            int y = node[0];
            
            for(int i = 0 ; i < move.length; i++){
                int nx = x+move[i][1];
                int ny = y+move[i][0];
                
                if( nx >=0 && nx < maps[0].length && ny >=0 && ny < maps.length &&
                   !visited[ny][nx] && maps[ny][nx] != 0){
                    visited[ny][nx] = true;
                    if(maps[ny][nx] == 1){
                        maps[ny][nx] += maps[y][x];
                    } else{
                        maps[ny][nx] = Math.min(maps[y][x]+1, maps[ny][nx]);
                    }
                    queue.add(new int[]{ny,nx});
                }
            }
            
        }
        if(!visited[rSize-1][cSize-1]){
            return -1;
        }
        return maps[rSize-1][cSize-1];
    }
}