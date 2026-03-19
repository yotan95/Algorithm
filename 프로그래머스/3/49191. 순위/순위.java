class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        
        for(int i = 0 ; i < results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for(int k = 1 ; k <= n; k++){
            for(int i = 1 ; i <= n; i++){
                if(k == i) continue;
                for(int j = 1 ; j <= n ; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if(graph[i][k] == -1 && graph[k][j] == -1){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1 ; i <= n; i++){
            boolean flag = true;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(graph[i][j] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}