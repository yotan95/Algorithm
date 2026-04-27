import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static int[] seq;
    static Deque<Integer> deq;
    
    public static void main(String[] args) throws IOException{
        readData();
        pro();
    }
    
    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        
        seq = new int[m];
        s = br.readLine().split(" ");
        for(int i = 0 ; i < m; i++){
            seq[i] = Integer.parseInt(s[i]);
        }
        deq = new ArrayDeque<Integer>();
        for(int i = 1 ; i <= n; i++){
            deq.add(i);
        }
    }
    
    private static void pro(){
        int answer = 0;
        for(int i = 0 ; i < m; i++){
            int target = seq[i];
            
            while(!deq.peekFirst().equals(target)){
                List<Integer> list = new ArrayList<>(deq);
                int idx= list.indexOf(target);
                int size = deq.size();
                int half;
                if (size % 2 == 0) {
                    half = size / 2 - 1;
                } else {
                    half = size / 2;
                }

                if (idx <= half) {
                    deq.addLast(deq.pollFirst());
                } else {
                    deq.addFirst(deq.pollLast()); 
                }
                answer++;
            }
            deq.pollFirst();
        }
        System.out.print(answer);
    }
}