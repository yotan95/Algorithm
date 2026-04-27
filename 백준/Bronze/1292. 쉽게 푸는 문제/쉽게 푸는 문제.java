import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        int a = Integer.parseInt(s[0]);
        int b =Integer.parseInt(s[1]);
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 1; list.size() <= b; i++){
            for(int j = 1; j <=i; j++){
                list.add(i);
            }
        }
        
        int answer = 0;
        for(; a<=b ; a++){
            answer += list.get(a-1);
        }
        
        System.out.print(answer);
    }
}