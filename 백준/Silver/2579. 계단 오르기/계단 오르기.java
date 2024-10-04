
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int total=0;
    static int[] step;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        step=new int[n+1];
        dp=new int[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            step[i]=Integer.parseInt(st.nextToken());
        }
        dp[1]=step[1];
        if(n>=2) dp[2]=step[1]+step[2];
        for (int i=3; i<=n; i++){
            dp[i]=Math.max(dp[i-2],dp[i-3]+step[i-1])+step[i];
        }
//        dfs(step[0],1,0);
//        dfs(step[1],1,1);
        System.out.println(dp[n]);
    }
//    public static void dfs(int score, int cnt,int idx){
//        if(idx>=n) return;
//        if(idx==n-1) {total=Math.max(total,score);return;}
//        if(cnt==2){
//            if(idx+2>n-1) return;
//            dfs(score+step[idx+2],1,idx+2);
//        }
//        else{
//            dfs(score+step[idx+1],cnt+1,idx+1);
//            if(idx+2>n-1) return;
//            dfs(score+step[idx+2],1,idx+2);
//        }
//
//    }
}
