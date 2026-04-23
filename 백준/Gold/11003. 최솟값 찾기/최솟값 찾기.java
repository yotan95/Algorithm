import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static int l;
    static int[] arr;

    public static void main(String[] arsgs)throws IOException{
        readData();
        pro();
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        arr = new int[n+1];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < n; i++){
            arr[i+1] = Integer.parseInt(s[i]);
        }
    }

    public static void pro(){
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deq = new ArrayDeque<int[]>();
        
        for(int i = 1; i <= n; i++){
            
            while(!deq.isEmpty() && deq.peekFirst()[0] < i - l +1){
                deq.pollFirst();
            }
            
            while(!deq.isEmpty() && deq.peekLast()[1] >= arr[i]){
                deq.pollLast();
            }
            
            deq.offerLast(new int[] {i, arr[i]});
            
            sb.append(deq.peekFirst()[1]).append(" ");
        }
        System.out.print(sb.toString());
    }
}