import  java.util.*;
import  java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[][] dp =new int[n][n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){

            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]){
                    for(int k=j; k<n; k++){
                        dp[j][k]=Math.max(dp[j][k],dp[i][j]+1);
                    }
                }
            }
        }
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if (max < dp[i][j]) max = dp[i][j];
            }
        }
        System.out.println(max+1);
        
    }

}