import java.util.*;

class Solution {
    
    static int[] roots;
    
    public int solution(int n, int[][] computers) { 
        roots = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            roots[i] = i;
        }
        
        for(int i = 0 ; i < computers.length; i++){
            for(int j = 0 ; j < computers.length; j++){
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < roots.length; i++){
            set.add(find(i));
        }
        
        
        
        return set.size();
    }
    
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) roots[rootB] = rootA;
    }
    
    public static int find(int x){
        if(roots[x] == x) return x;
        return roots[x] = find(roots[x]);
    }
}