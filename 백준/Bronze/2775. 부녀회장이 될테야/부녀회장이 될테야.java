import  java.util.*;
import  java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[15][15];
        for(int i=1; i<=14; i++){
            dp[0][i]=i;
        }
        for(int i=1; i<15; i++){
            for(int j=1; j<=14; j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] ans = new int[t];
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int k= Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ans[i]=dp[k][n];
        }
        for(int i=0; i<t; i++){
            System.out.println(ans[i]);
        }
    }

}