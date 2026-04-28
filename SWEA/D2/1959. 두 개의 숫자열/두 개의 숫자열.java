import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] s = br.readLine().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            int max = Integer.MIN_VALUE;
            
            s = br.readLine().split(" ");
            for(int i = 0 ; i < n; i++) arr1[i] = Integer.parseInt(s[i]);
            s = br.readLine().split(" ");
            for(int i = 0 ; i < m; i++) arr2[i] = Integer.parseInt(s[i]);
            
            
            int diff = Math.abs(arr1.length -arr2.length);
            if(arr1.length < arr2.length){
                for(int i = 0 ; i <= diff; i++  ){
                    int sum = 0 ;
                    for(int j = 0 ; j < arr1.length; j++){
                        sum += (arr1[j] * arr2[j+i]);
                    }
                    max = Math.max(max, sum);
                }
            }else{
                for(int i = 0 ; i <= diff; i++  ){
                    int sum = 0 ;
                    for(int j = 0 ; j < arr2.length; j++){
                        sum += (arr1[i+j] * arr2[j]);
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}