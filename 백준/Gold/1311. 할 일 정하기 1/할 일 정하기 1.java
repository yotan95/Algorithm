import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        readData();
        pro();
    }

    public static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0] = 0;                          

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
    }

    public static void pro() { 
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            int current = Integer.bitCount(i);
            if (current == n) continue;

            for (int work = 0; work < n; work++) {
                if ((i & (1 << work)) == 0) { 
                    int next = i | (1 << work);
                    dp[next] = Math.min(dp[next], dp[i] + graph[current][work]); 
                }
            }
        }
        System.out.print(dp[(1 << n) - 1]);
    }
}