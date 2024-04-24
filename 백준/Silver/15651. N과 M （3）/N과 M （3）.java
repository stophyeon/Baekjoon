import java.util.Scanner;

public class Main{
    static int[] res;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        res = new int[m];
        
        dfs(0);
        System.out.println(sb);
       
    }
    static void dfs(int depth){
        if(depth==m){
            for(int i=0; i<depth; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<n; i++){
            res[depth]=i+1;
            dfs(depth+1);
        }
    }
}