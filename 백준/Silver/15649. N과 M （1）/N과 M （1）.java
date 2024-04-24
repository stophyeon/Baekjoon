import java.util.Scanner;

public class Main{
    static int[] res;
    static boolean[] v;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        res = new int[m];
        v= new boolean[n];
        dfs(n,m,0);
        
       
    }
    static void dfs(int n,int m,int depth){
        if(depth==m){
            for(int i=0; i<depth; i++){
                System.out.print(res[i]+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=0; i<n; i++){
            if(v[i]==false){
                v[i]=true;
                res[depth]=i+1;
                dfs(n,m,depth+1);
                v[i]=false;
            }
            
        }
    }
}