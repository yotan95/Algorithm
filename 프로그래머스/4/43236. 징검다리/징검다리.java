import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(isVaild(mid, distance, rocks, n)){
                answer = mid;
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    private static boolean isVaild(int x, int distance, int[] rocks, int n){
        
        int current = 0;
        int remove = 0;
        
        for(int i = 0 ; i < rocks.length; i++){
            int mid = rocks[i];
            int gap = mid - current;
            
            if(gap < x){
                remove++;
            }else{
                current = mid;
            }
            
        }
        
        int last = distance - current;
        if(last <x){
            remove++;
        }
        return remove <= n;

    }
    
}