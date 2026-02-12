import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static int[] set;
    
    public static void main(String[] args) throws IOException{
        readData();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        set = new int[n+1];
        
        for(int i = 0 ; i < set.length; i++){
                set[i] = i;
        }
        for(int i = 0 ; i < m ; i++){
            
            
            s = br.readLine().split(" ");
            int op = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            
            if(op == 0){
                pro(a,b);
            }else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        
    }
    public static void pro(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB) set[rootB] = rootA;
    }
    
    public static int find(int a){
        if(set[a] == a) return a;
        return set[a] = find(set[a]);
    }
    
}