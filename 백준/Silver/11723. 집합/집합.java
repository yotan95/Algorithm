import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int set = 0;
        for(int i = 0 ; i < m ; i++){
            String[] s = br.readLine().split(" ");

            String el1;
            int el2;
            if(s.length < 2 ){
                el1 = s[0];
                el2= 0;
            }else{
                el1 = s[0];
                el2 = Integer.parseInt(s[1]);
            }

            if(el1.equals("add")){
                set |= (1 << el2);
            }else if(el1.equals("remove")){
                set &= ~(1 << el2);
            }else if(el1.equals("check")){
                sb.append((set & (1 <<  el2)) != 0 ? 1 : 0).append('\n');
            }else if(el1.equals("toggle")){
                set ^= (1 << el2);
            }else if(el1.equals("all")){
                set = (1 << 21) -2;
            }else if(el1.equals("empty")){
                set = 0;
            }
        }
        System.out.print(sb);
    }
    
}