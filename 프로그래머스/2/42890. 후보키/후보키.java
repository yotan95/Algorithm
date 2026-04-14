import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        
        int colSize = relation[0].length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i < (1 << colSize); i++){
            Set<String> set = new HashSet<String>();
            
            for(String[] row : relation){
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < colSize; j++){
                    if((i & (1 << j)) != 0){
                        sb.append(row[j]).append(",");
                    }
                }
                set.add(sb.toString());
            }
            if(set.size() == relation.length){
                boolean isValid = true;
                
                for(int key : list){
                    if((i & key) == key){
                        isValid = false;
                        break;
                    }
                }
                
                if(isValid) list.add(i);
            }
        }
        
        return list.size();
    }
}