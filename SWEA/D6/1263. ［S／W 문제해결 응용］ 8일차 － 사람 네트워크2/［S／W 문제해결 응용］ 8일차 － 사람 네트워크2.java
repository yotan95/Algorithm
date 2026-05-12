import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer  st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] graph = new int[n][n];
            for(int i = 0; i < n ; i++){
            	for(int j =0 ; j <n; j++){
                	graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] nodeCount = new int[n];
            for(int i = 0 ; i < n ;i++){
                int[] dist = new int[n];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[i] = 0;
            	PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
                queue.offer(new int[] {i, 0});
                while(!queue.isEmpty()){
                	int[] cur = queue.poll();
                    int startNode = cur[0];
                    int  count = cur[1];
                    
                    if(count > dist[startNode]) continue;
                    
                    int[] next = graph[startNode];
                    for(int j = 0; j < next.length; j++){
                    	if(next[j] != 0 && i != j ){
                        	int newCount = count + next[j];
                            if(newCount <dist[j]){
                                dist[j] = newCount;
                            	queue.offer(new int[] {j, newCount});
                            }
                        }
                    }
                }
                int sum = 0;
                for(int s: dist) sum +=s;
                nodeCount[i] = sum;
            }
            int answer = Integer.MAX_VALUE;
            for(int m : nodeCount){
            	if(m < answer){
                	answer = m;
                }
            }
            
            System.out.println("#"+test_case+" "+ answer);
		}
	}
}